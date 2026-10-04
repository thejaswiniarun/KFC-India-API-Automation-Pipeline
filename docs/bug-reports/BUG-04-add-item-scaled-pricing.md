# BUG-04: Single item subtotal returned scaled integer parameters

| Field | Details |
|-------|---------|
| **Severity** | Critical |
| **Priority** | P1 |
| **Status** | Open |
| **Found On** | 2026-10-04 |
| **Endpoint** | `POST carts/items` |
| **Test Case ID** | TC_CRT_01 |

## Description
Subtotal arithmetic scaling defect. Adding a valid single product item returns a scaled integer representation (`58572`) rather than format floating-decimal currency figures.

## Preconditions
- Product layout menu tree index has successfully parsed.

## Steps to Reproduce
1. Send a POST request payload containing standard selection attributes: `{"itemId": "L-8000350", "quantity": 1}`.

## Expected Result
The system calculates pricing parameters and responds with formatted float objects representing true pricing.

## Actual Result
The engine outputs anomalous integer properties: `"subtotal": 58572`.

## Request / Response
```json
{
  "request": {
    "body": { "itemId": "L-8000350", "quantity": 1 }
  },
  "response": {
    "status": 200,
    "data": { "subtotal": 58572 }
  }
}
```
## Evidence
![Screenshot](../test-evidence/bugs/BUG-04-response.png)
