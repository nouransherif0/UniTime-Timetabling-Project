# Phase 1 - Step 3: Static Code Analysis
## Done by Rahma Waleed - 20236035

## Tool Used
SonarQube Community Edition 26.3, run locally via SonarScanner CLI from the command line on the UniTime Java source code.

## Results
- Total lines of code: 602,000
- Total issues found: 39,710
- Reliability issues (bugs): 407
- Security vulnerabilities: 2
- Maintainability issues (code smells): 39,000+
- Security hotspots requiring manual review: 190
- Code duplication rate: 13.3% across 752,000 lines
- Test coverage: 0.0%
- Estimated effort to resolve all issues: 963 days

## Quality Gate
- Overall status: Passed
- Maintainability rating: A
- Security rating: E
- Reliability rating: E

## Notes
These results serve as a baseline for Phase 2, where a second SonarQube scan
will be run after implementing features to measure the impact on code quality.
