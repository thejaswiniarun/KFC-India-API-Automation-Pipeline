# BUG-07: Out of stock validation maps true status to unavailable items

| Field | Details |
|-------|---------|
| **Severity** | Critical |
| **Priority** | P1 |
| **Status** | Open |
| **Found On** | 2026-10-04 |
| **Endpoint** | `GET catalogs/...?check=stock` |
| **Test Case ID** | TC_BSK_001 |

## Description
Business validation failure logic. The checkout basket engine flags un-orderable or unavailable elements as completely valid for final transaction loops.

## Preconditions
- Selected items are flagged as un-orderable or sold out.

## Steps to Reproduce
1. Run a stock verification check request tracking an out-of-stock item context profile.

## Expected Result
The system correctly catches item flags and reports transactional validation failures for sold-out variants.

## Actual Result
The validation evaluation responds with true flags regardless: `isAvailable: false, validStatus: true`.

## Request / Response
```json
{
  "request": { "query": "?check=stock" },
  "response": {
    "status": 200,
    "data": { "isAvailable": false, "validStatus": true }
  }
}
```
## Evidence
![Screenshot](../test-evidence/bugs/BUG-07-response.png)
