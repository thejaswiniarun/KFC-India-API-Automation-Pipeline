# BUG-10: Tax base calculation values return empty zero properties

| Field | Details |
|-------|---------|
| **Severity** | High |
| **Priority** | P2 |
| **Status** | Open |
| **Found On** | 2026-10-04 |
| **Endpoint** | `GET catalogs/...?check=tax-base` |
| **Test Case ID** | TC_BSK_004 |

## Description
Financial compliance tracking mismatch. The subtotal property tracking applied taxable base logic displays as 0, failing to aggregate individual item values.

## Preconditions
- The checkout basket contains multiple taxable line items.

## Steps to Reproduce
1. Run execution sweep for cumulative transaction tax component parameters.

## Expected Result
The system aggregates the data and populates total metrics: `itemAmountOnTaxApplied` matches the combined taxable subtotal.

## Actual Result
The property parameters reset to zero during layout mapping execution: `itemAmountOnTaxApplied: 0`.

## Request / Response
```json
{
  "request": { "query": "?check=tax-base" },
  "response": {
    "status": 200,
    "data": { "itemAmountOnTaxApplied": 0 }
  }
}
```
## Evidence
![Screenshot](../test-evidence/bugs/BUG-10-response.png)
