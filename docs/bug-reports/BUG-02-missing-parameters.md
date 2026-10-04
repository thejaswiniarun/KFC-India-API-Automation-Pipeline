# BUG-02: Empty route query parameter handles bypass verification with 200 OK

| Field | Details |
|-------|---------|
| **Severity** | Medium |
| **Priority** | P3 |
| **Status** | Open |
| **Found On** | 2026-10-04 |
| **Endpoint** | `GET catalogs/15895bb59f7b4bb588ee933f8cd5344a/KFCIndiaMenu-1726-web-pickup?mode=` |
| **Test Case ID** | TC_STR_06 |

## Description
The API maps empty parameter sequences directly to default success flows, ignoring query constraint checks and responding with 200 OK.

## Preconditions
- Active network configuration client is whitelisted.

## Steps to Reproduce
1. Direct a GET query request to the menu catalog.
2. Append empty matrix parameter attributes: `?mode=`.

## Expected Result
System rejects unparameterized criteria calls with an explicit 400 Bad Request validation layout block.

## Actual Result
The request is processed and succeeds with a `200 OK` response returning blank data indicators.

## Request / Response
```json
{
  "request": {
    "url": "https://.../KFCIndiaMenu-1726-web-pickup?mode="
  },
  "response": {
    "status": 200,
    "body": "{}"
  }
}
```
## Evidence
![Screenshot](../test-evidence/bugs/BUG-02-response.png)
