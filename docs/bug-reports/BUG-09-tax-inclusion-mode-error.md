# BUG-09: Inclusive pricing model structures default back to false flags

| Field | Details |
|-------|---------|
| **Severity** | High |
| **Priority** | P2 |
| **Status** | Open |
| **Found On** | 2026-10-04 |
| **Endpoint** | `GET catalogs/...?check=taxes` |
| **Test Case ID** | TC_BSK_003 |

## Description
Tax compliance mapping mismatch. The system marks fully tax-inclusive items as exclusive, creating downstream errors in financial calculations.

## Preconditions
- The menu items contain pre-calculated built-in local tax parameters.

## Steps to Reproduce
1. Query target product context properties tax maps.

## Expected Result
Tax configuration loops capture layout settings accurately and display: `isTaxIncludedInItemPrice: true`.

## Actual Result
The engine drops settings and returns a false descriptor indicator: `isTaxIncludedInItemPrice: false`.

## Request / Response
```json
{
  "request": { "query": "?check=taxes" },
  "response": {
    "status": 200,
    "data": { "isTaxIncludedInItemPrice": false }
  }
}
```
## Evidence
![Screenshot](../test-evidence/bugs/BUG-09-response.png)
