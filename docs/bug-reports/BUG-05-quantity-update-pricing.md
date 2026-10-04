# BUG-05: Multi-item quantity recalculation yields mathematical scaling bug

| Field | Details |
|-------|---------|
| **Severity** | Critical |
| **Priority** | P1 |
| **Status** | Open |
| **Found On** | 2026-10-04 |
| **Endpoint** | `PUT carts/items` |
| **Test Case ID** | TC_CRT_03 |

## Description
Pricing multiplier logic anomaly. Adjusting product item numbers scaling updates numbers incorrectly to integer values (`78096`) instead of floating-point standards.

## Preconditions
- Target item exists inside active session database logs.

## Steps to Reproduce
1. Execute a PUT update call with modified count requirements: `{"itemId": "L-8000350", "quantity": 2}`.

## Expected Result
Pricing properties increase in precise proportion to item scale changes.

## Actual Result
Calculations output scaled integer properties: `"subtotal": 78096`.

## Request / Response
```json
{
  "request": {
    "body": { "itemId": "L-8000350", "quantity": 2 }
  },
  "response": {
    "status": 200,
    "data": { "subtotal": 78096 }
  }
}
```
## Evidence
![Screenshot](../test-evidence/bugs/BUG-05-response.png)
