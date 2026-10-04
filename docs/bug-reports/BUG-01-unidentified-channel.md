# BUG-01: Unidentified Channel fallback routing allowed

| Field | Details |
|-------|---------|
| **Severity** | High |
| **Priority** | P2 |
| **Status** | Open |
| **Found On** | 2026-10-04 |
| **Endpoint** | `GET catalogs/15895bb59f7b4bb588ee933f8cd5344a/KFCIndiaMenu-1726-web-pickup` |
| **Test Case ID** | TC_STR_03 |

## Description
API response returns a successful 200 OK status containing empty array configurations instead of throwing a standard 400 Bad Request error framework block when channel keys are corrupted or unrecognized.

## Preconditions
- Operational whitelisted gateway session token is set.

## Steps to Reproduce
1. Direct a GET request to the menu catalog route.
2. Inject header value parameter modification: `X-Channel-Id: INVALID_CHANNEL`.

## Expected Result
The enterprise security layer should intercept the call and return an explicit `400 Bad Request` or channel rejection validation status block.

## Actual Result
The API returns a `200 OK` status with an unpopulated or empty metadata array string payload.

## Request / Response
```json
{
  "request": {
    "headers": {
      "X-Channel-Id": "INVALID_CHANNEL"
    }
  },
  "response": {
    "status": 200,
    "body": {}
  }
}
```
## Evidence
![Screenshot](../test-evidence/bugs/BUG-01-response.png)
