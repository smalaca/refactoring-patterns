package com.smalaca.application.service;

import com.smalaca.application.response.Response;
import com.smalaca.domain.Branch;
import com.smalaca.domain.BranchRepository;
import com.smalaca.notification.NotificationSender;

public class BranchApplicationService {
    private final BranchRepository branchRepository;
    private final NotificationSender notificationSender;

    public BranchApplicationService(BranchRepository branchRepository, NotificationSender notificationSender) {
        this.branchRepository = branchRepository;
        this.notificationSender = notificationSender;
    }

    public Response rebase(String fromId, String toId, String login) {
        Branch from = branchRepository.find(fromId);
        Branch to = branchRepository.find(toId);

        if (to.canBeRebasedWith(from)) {
            to.rebaseWith(from);
            branchRepository.save(to);
            notificationSender.notify("Successfully rebased", login);
            return Response.success();
        } else {
            notificationSender.notify("Couldn't rebase", login);
            return Response.success();
        }
    }
}
