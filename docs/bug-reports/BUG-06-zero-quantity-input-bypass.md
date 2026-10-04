# BUG-06: API fails input boundary test for null or zero volume variations

| Field | Details |
|-------|---------|
| **Severity** | Critical |
| **Priority** | P1 |
| **Status** | Open |
| **Found On** | 2026-10-04 |
| **Endpoint** | `PUT carts/items` |
| **Test Case ID** | TC_CRT_04 |

## Description
The backend fails to enforce mandatory validation checks for zero-quantity items, skipping safety thresholds and missing the standard error token `BSDE002`.

## Preconditions
- Active selection row maps to valid product.

## Steps to Reproduce
1. Direct a update payload matching the criteria boundaries: `{"itemId": "L-8000350", "quantity": 0}`.

## Expected Result
The core framework intercepts the request and throws a `400 Bad Request` containing validation error identifier code `BSDE002`.

## Actual Result
The input parameters bypass security thresholds without generating the expected validation error blocks.

## Request / Response
```json
{
  "request": {
    "body": { "itemId": "L-8000350", "quantity": 0 }
  },
  "response": {
    "status": 405,
    "error": "Method Not Allowed"
  }
}
```
## Evidence
![Screenshot](../test-evidence/bugs/BUG-06-response.png)
