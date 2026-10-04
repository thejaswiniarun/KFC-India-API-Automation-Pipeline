# BUG-08: Charity donation metrics map total value back to 0 unexpectedly

| Field | Details |
|-------|---------|
| **Severity** | High |
| **Priority** | P2 |
| **Status** | Open |
| **Found On** | 2026-10-04 |
| **Endpoint** | `GET catalogs/...?check=summary` |
| **Test Case ID** | TC_BSK_002 |

## Description
Optional donations mapping failure. The `addHopeTotal` data structure resets back to 0 even when valid contribution indices are parsed inside item rows.

## Preconditions
- Active basket collection contains verified donation items.

## Steps to Reproduce
1. Query session order totals summary.
2. Confirm contribution item row parameters match value metrics: `amount: 500`.

## Expected Result
The general checkout wrapper captures row details and sets the parent property string value completely: `addHopeTotal: 500`.

## Actual Result
The mapping parameters drop values completely during execution: `addHopeTotal: 0`.

## Request / Response
```json
{
  "request": { "query": "?check=summary" },
  "response": {
    "status": 200,
    "data": { "foodLines": [ { "name": "Donation", "amount": 500 } ], "addHopeTotal": 0 }
  }
}
```
## Evidence
![Screenshot](../test-evidence/bugs/BUG-08-response.png)
