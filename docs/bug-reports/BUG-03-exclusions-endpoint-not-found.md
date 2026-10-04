# BUG-03: Exclusions endpoint throws 404 instead of returning blank arrays

| Field | Details |
|-------|---------|
| **Severity** | High |
| **Priority** | P2 |
| **Status** | Open |
| **Found On** | 2026-10-04 |
| **Endpoint** | `GET catalogs/.../KFCIndiaMenu-1726-web-pickup/item-exclusions` |
| **Test Case ID** | TC_CAT_04 |

## Description
The store item exclusions locator endpoint is missing or blocked entirely under this gateway profile, returning a 404 Not Found instead of empty array boundaries.

## Preconditions
- Menu catalog session mapping is active.

## Steps to Reproduce
1. Direct a GET sequence call to the item-exclusions sub-route path.

## Expected Result
The backend engine resolves the call successfully with `200 OK` and prints an empty structured collection string `[]`.

## Actual Result
The service throws an unexpected resource failure code: `404 Not Found`.

## Request / Response
```json
{
  "request": {
    "url": "https://.../KFCIndiaMenu-1726-web-pickup/item-exclusions"
  },
  "response": {
    "status": 404,
    "error": "Not Found"
  }
}
```
## Evidence
![Screenshot](../test-evidence/bugs/BUG-03-response.png)
