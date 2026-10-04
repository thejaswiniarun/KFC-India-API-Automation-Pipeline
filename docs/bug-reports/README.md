# 🐞 Bug Reports

This folder contains defects found while testing the KFC India backend APIs.
Each bug has its own file with steps to reproduce, expected vs. actual results,
and evidence.

## Summary

| ID | Title | Severity | Status |
|----|-------|----------|--------|
| BUG-01 | Unidentified Channel fallback allowed | High | Open |
| BUG-02 | Missing Parameters returns 200 OK | Medium | Open |
| BUG-03 | Store Item Exclusions endpoint yields 404 | High | Open |
| BUG-04 | Add Valid Item returns scaled integer subtotal | Critical | Open |
| BUG-05 | Quantity Update pricing scale calculation defect | Critical | Open |
| BUG-06 | Null/Zero values update validation check failure | Critical | Open |
| BUG-07 | Out of stock validation flags allow unavailable items | Critical | Open |
| BUG-08 | Charity Add Hope totals mapped incorrectly to 0 | High | Open |
| BUG-09 | System reports false for active tax-inclusive items | High | Open |
| BUG-10 | Tax base calculation applied returns 0 subtotal value | High | Open |

## How bugs are reported

1. Copy [`BUG-TEMPLATE.md`](BUG-TEMPLATE.md)
2. Rename it `BUG-001-short-title.md`
3. Fill in the details and attach screenshots from `../test-evidence/bugs/`
4. Add a row to the summary table above

## Severity guide

| Severity | Meaning |
|----------|---------|
| Critical | Core flow is broken (e.g. cart or checkout fails) |
| High | Wrong data or calculation (e.g. incorrect total) |
| Medium | Incorrect behaviour with a workaround |
| Low | Minor issue, cosmetic data or naming |
