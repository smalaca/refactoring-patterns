* Composing Methods
    * Introduce Explaining Variable - ```RefactoringProposition.averageNumberOfCommits```
    * Split Temporary Variable - ```ChangeScope.affectedLinesOfCode```
    * Replace Template with Query - ```ChangeScope.latestChangeEpochDay```
    * Inline Method - ```RefactoringProposition.moreThanHundredAffectedLinesOfCode```
    * Extract Method - ```RefactoringProposition.isRequired```
    * Remove Assignments to Parameters - ```CodeClass.hasMoreLinesThan```
    
* Simplify Methods Calls
    * Replace Constructor with Factory Method - ```User.constructor```
    * ErrorCode with Exception - ```PullRequestService.merge```
    * Exception with Test - ```PullRequestApplicationService.merge```
    * Parameter with Explicit Methods - ```Coverage.is```
    * Parameter with Method - ```PullRequest.isPossibleToMergeTo```
    * Introduce Parameter Object - ```History```
    * Encapsulate Downcast - ```PullRequestsRepository```
    
* Moving Features between Objects
    * Move Method i Move Field - more usage in different class (TO DRAW)
    * Extract Class - ```User.address```
    * Inline Class - ```User.email```
    * Hide Delegate - ```Commit.getAuthor```
    * Remove Middle Man - ```User & address getters```
    * Introduce Foreign Method - ```MailNotificationSender.send.delayed```
    * Introduce Local Extension - ```MailNotificationSender.send.delayed into extension```
    
* Organizing Data
    * Replace Array with Object - ```PullRequest.commits, ChangeScope.commits, Branch.commits```
    * Data Value with Object - ```Author, Reviewer, User -> login```
    * Magic Number with Symbolic Constant - ```RefactoringProposition.isRequired```
    * Record with Data Class - ```Commit.message```
    * Subclass with Fields - ```ChangeRequest, Fix, Improvement as type```
    * Type Code with Class - ```PullRequest, reviewers type```
    * Type Code with Strategy/State - part of behavior depends on type (TO DRAW, NEXT REPO) 
    * Type Code with Subclasses - most of behavior depends on type (TO DRAW, NEXT REPO)
    * Encapsulate Collection, Encapsulate Field - ```Commit.branches```
    * Change Bidirectional Association to Unidirectional/Change Bidirectional Unidirectional to Association - ```Commit.branches```
    
* Simplifying Conditional Expressions
    * Decompose Conditional Expressions - ```RefactoringProposition.isRequired```
    * Consolidate Conditional Expressions - ```IsRefactoringRequiredPredicate``` 
    * Consolidate Duplicate Conditional Expressions - ```BranchApplicationService.rebase - notification```
    * Replace Nested Conditional with Guard Clauses - ```CodeClass.linesOfCode```
    * Replace Conditional with Polymorphism - ```CodeClass and CodeClassType into classes```
    * Null Object - ```CodeClass.parent```
    
* Dealing with Generalization
    * Pull Up Constructor Body, Field, Method - ```codestructure.ClassFile, EnumFile, InterfaceFile```
    * Push Down Field, Method - ```CodeClass.parent```
    * Collapse Hierarchy - ```NotificationSender and MailNotificationSender```
    * Extract Interface, Subclass, Superclass - ```CodeClass.linesOfCode```
    * Replace Inheritance with Delegation/Replace Delegation with Intheritance - ```CodeClass.linesOfCode```
