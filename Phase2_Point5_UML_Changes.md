Phase 2 - Point 5: UML Model Changes After Implementation
## What this PR does

This pull request documents Phase 2 - Point 5 done by Hager Amr - 20236112.
It shows how the UML class diagram changed after all features 
and bug fixes were implemented in the UniTime system.

## UML Changes Summary

### New Classes Added (Features)
- TimetableNotificationService → Feature 1: Email Notification
- TimetablePDFExporter → Feature 2: Export to PDF
- TimetableSearchFilter → Feature 3: Search/Filter by Course Name
- ClassNote → Feature 4: Add Notes to a Class

### Existing Classes Modified (Bug Fixes)
- ClassAssignment → Bug #1 (hardcoded token) and Bug #5 (copy constructor)
- ClassInfoModel → Bug #2 (missing return statement)
- ClassTimeInfo → Bug #4 (bitwise & replaced with logical &&)

## Numbers
- Total classes before: 9
- Total classes after: 13
- New classes added: 4
- New relationships added: 4
- Classes modified: 3
- New methods added: 1 copy constructor
