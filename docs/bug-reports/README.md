# 🐞 Bug Reports

Defects found while testing the KFC India backend APIs. Each bug has its own
file with steps to reproduce, expected vs. actual results, and evidence.

## Summary

| ID | Title | Severity | Priority | Test Case | Status |
|----|-------|----------|----------|-----------|--------|
| [BUG-01](BUG-01-unidentified-channel.md) | Unidentified Channel fallback allowed | High | P2 | TC_STR_03 | Open |
| [BUG-02](BUG-02-missing-parameters.md) | Missing Parameters returns 200 OK | Medium | P3 | TC_STR_06 | Open |
| [BUG-03](BUG-03-exclusions-endpoint-not-found.md) | Store Item Exclusions endpoint yields 404 | High | P2 | TC_CAT_04 | Open |
| [BUG-04](BUG-04-add-item-scaled-pricing.md) | Add Valid Item returns scaled integer subtotal | Critical | P1 | TC_CRT_01 | Open |
| [BUG-05](BUG-05-quantity-update-pricing.md) | Quantity Update pricing scale calculation defect | Critical | P1 | TC_CRT_03 | Open |
| [BUG-06](BUG-06-zero-quantity-input-bypass.md) | Null/Zero quantity validation check failure | Critical | P1 | TC_CRT_04 | Open |
| [BUG-07](BUG-07-out-of-stock-validation.md) | Out-of-stock items flagged as valid | Critical | P1 | TC_BSK_001 | Open |
| [BUG-08](BUG-08-charity-mapping-wiped.md) | Charity Add Hope total mapped to 0 | High | P2 | TC_BSK_002 | Open |
| [BUG-09](BUG-09-tax-inclusion-mode-error.md) | Tax-inclusive items reported as exclusive | High | P2 | TC_BSK_003 | Open |
| [BUG-10](BUG-10-tax-base-calculation-zero.md) | Tax base amount returns 0 | High | P2 | TC_BSK_004 | Open |

**By severity:** Critical 4 · High 5 · Medium 1 · Low 0

## How bugs are reported

1. Copy [`BUG-TEMPLATE.md`](BUG-TEMPLATE.md)
2. Rename it `BUG-NN-short-title.md` (e.g. `BUG-11-cart-timeout.md`)
3. Fill in the details and attach screenshots from [`../test-evidence/bugs/`](../test-evidence/bugs/)
4. Add a row to the summary table above

## Severity guide

| Severity | Meaning |
|----------|---------|
| Critical | Core flow is broken (e.g. cart or checkout fails) |
| High | Wrong data or calculation (e.g. incorrect total) |
| Medium | Incorrect behaviour with a workaround |
| Low | Minor issue, cosmetic data or naming |

## Priority guide

| Priority | Meaning |
|----------|---------|
| P1 | Fix immediately, blocks ordering |
| P2 | Fix in the next release |
| P3 | Fix when capacity allows |
