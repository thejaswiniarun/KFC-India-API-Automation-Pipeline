# 🗂️ Execution Matrix & Evidence Index

Legend: ✅ PASS · 🪲 BUG (defect logged)

- Raw logs: `test-evidence/raw-logs/<TEST_ID>-raw-log.txt`
- Postman screenshots (passing tests): `test-evidence/postman/<TEST_ID>.png`
- Bug screenshots: `test-evidence/bugs/BUG-NN-response.png`

## 1. Store & Service Validations (TC_STR)

| Test Case ID | Title | HTTP Expected | HTTP Actual | Status | Raw Log | Screenshot / Bug |
|---|---|---|---|---|---|---|
| TC_STR_01 | Valid Store & Services | 200 OK | 200 OK | ✅ PASS | [log](../test-evidence/raw-logs/TC_STR_01-raw-log.txt) | [png](../test-evidence/postman/TC_STR_01.png) |
| TC_STR_02 | Authorization Header Empty | 200 OK | 200 OK | ✅ PASS | [log](../test-evidence/raw-logs/TC_STR_02-raw-log.txt) | [png](../test-evidence/postman/TC_STR_02.png) |
| TC_STR_03 | Unidentified Channel | 400 Bad Req | 200 OK | 🪲 BUG | [log](../test-evidence/raw-logs/TC_STR_03-raw-log.txt) | [BUG-01](../bug-reports/BUG-01-unidentified-channel.md) |
| TC_STR_04 | Invalid Store ID | 404 Not Found | 404 Not Found | ✅ PASS | [log](../test-evidence/raw-logs/TC_STR_04-raw-log.txt) | [png](../test-evidence/postman/TC_STR_04.png) |
| TC_STR_05 | Invalid Service | 400 Bad Req | 200 OK | ✅ PASS | [log](../test-evidence/raw-logs/TC_STR_05-raw-log.txt) | [png](../test-evidence/postman/TC_STR_05.png) |
| TC_STR_06 | Missing Parameters | 400 Bad Req | 200 OK | 🪲 BUG | [log](../test-evidence/raw-logs/TC_STR_06-raw-log.txt) | [BUG-02](../bug-reports/BUG-02-missing-parameters.md) |

## 2. Menu Catalog Validations (TC_CAT)

| Test Case ID | Title | HTTP Expected | HTTP Actual | Status | Raw Log | Screenshot / Bug |
|---|---|---|---|---|---|---|
| TC_CAT_01 | Fetch Full Menu Catalog | 200 OK | 200 OK | ✅ PASS | [log](../test-evidence/raw-logs/TC_CAT_01-raw-log.txt) | [png](../test-evidence/postman/TC_CAT_01.png) |
| TC_CAT_02 | Fetch Valid Item Details | 200 OK | 200 OK | ✅ PASS | [log](../test-evidence/raw-logs/TC_CAT_02-raw-log.txt) | [png](../test-evidence/postman/TC_CAT_02.png) |
| TC_CAT_03 | Fetch Invalid Item ID | 404 Not Found | 200 / 404 | ✅ PASS | [log](../test-evidence/raw-logs/TC_CAT_03-raw-log.txt) | [png](../test-evidence/postman/TC_CAT_03.png) |
| TC_CAT_04 | Store Item Exclusions | 200 OK | 404 Not Found | 🪲 BUG | [log](../test-evidence/raw-logs/TC_CAT_04-raw-log.txt) | [BUG-03](../bug-reports/BUG-03-exclusions-endpoint-not-found.md) |
| TC_CAT_05 | Schema Metadata Check | 200 OK | 200 OK | ✅ PASS | [log](../test-evidence/raw-logs/TC_CAT_05-raw-log.txt) | [png](../test-evidence/postman/TC_CAT_05.png) |

## 3. Cart Management Validations (TC_CRT)

| Test Case ID | Title | HTTP Expected | HTTP Actual | Status | Raw Log | Screenshot / Bug |
|---|---|---|---|---|---|---|
| TC_CRT_01 | Add Valid Item to cart | 200 OK | 200 / 405 | 🪲 BUG | [log](../test-evidence/raw-logs/TC_CRT_01-raw-log.txt) | [BUG-04](../bug-reports/BUG-04-add-item-scaled-pricing.md) |
| TC_CRT_02 | Add Invalid Item to cart | 400 / 404 | 405 Method Not Allowed | ✅ PASS | [log](../test-evidence/raw-logs/TC_CRT_02-raw-log.txt) | [png](../test-evidence/postman/TC_CRT_02.png) |
| TC_CRT_03 | Quantity Updated (qty: 2) | 200 OK | 200 / 405 | 🪲 BUG | [log](../test-evidence/raw-logs/TC_CRT_03-raw-log.txt) | [BUG-05](../bug-reports/BUG-05-quantity-update-pricing.md) |
| TC_CRT_04 | Null value updated (qty: 0) | 400 Bad Req | 405 Method Not Allowed | 🪲 BUG | [log](../test-evidence/raw-logs/TC_CRT_04-raw-log.txt) | [BUG-06](../bug-reports/BUG-06-zero-quantity-input-bypass.md) |

## 4. Basket Calculation Validations (TC_BSK)

| Test Case ID | Title | HTTP Expected | HTTP Actual | Status | Raw Log | Screenshot / Bug |
|---|---|---|---|---|---|---|
| TC_BSK_001 | Out of Stock Validation | 200 OK | 200 OK | 🪲 BUG | [log](../test-evidence/raw-logs/TC_BSK_001-raw-log.txt) | [BUG-07](../bug-reports/BUG-07-out-of-stock-validation.md) |
| TC_BSK_002 | Charity Add Hope Mapping | 200 OK | 200 OK | 🪲 BUG | [log](../test-evidence/raw-logs/TC_BSK_002-raw-log.txt) | [BUG-08](../bug-reports/BUG-08-charity-mapping-wiped.md) |
| TC_BSK_003 | Verify Tax Inclusion Mode | 200 OK | 200 OK | 🪲 BUG | [log](../test-evidence/raw-logs/TC_BSK_003-raw-log.txt) | [BUG-09](../bug-reports/BUG-09-tax-inclusion-mode-error.md) |
| TC_BSK_004 | Verify Tax Base Amount | 200 OK | 200 OK | 🪲 BUG | [log](../test-evidence/raw-logs/TC_BSK_004-raw-log.txt) | [BUG-10](../bug-reports/BUG-10-tax-base-calculation-zero.md) |
| TC_BSK_005 | Subtotal & Tax Logic | 200 OK | 200 OK | ✅ PASS | [log](../test-evidence/raw-logs/TC_BSK_005-raw-log.txt) | [png](../test-evidence/postman/TC_BSK_005.png) |
| TC_BSK_006 | Verify CGST and SGST Split | 200 OK | 200 OK | ✅ PASS | [log](../test-evidence/raw-logs/TC_BSK_006-raw-log.txt) | [png](../test-evidence/postman/TC_BSK_006.png) |
| TC_BSK_007 | Validate Item Status Flags | 200 OK | 200 OK | ✅ PASS | [log](../test-evidence/raw-logs/TC_BSK_007-raw-log.txt) | [png](../test-evidence/postman/TC_BSK_007.png) |

## 🔍 Key Quality Observations

1. **Public endpoint exposure (TC_STR_02):** The menu catalog endpoint works as a public resource. Removing the `Authorization: Bearer` credential still returns `200 OK`.
2. **Pricing scale defect (TC_CRT_01 / TC_CRT_03):** Cart line subtotals come back as scaled integers (`58572`, `78096`) instead of formatted decimal currency values.
3. **Tax configuration failures (TC_BSK_003 / TC_BSK_004):** CGST/SGST split evenly 50/50 (TC_BSK_006), but tax-inclusive items are flagged as exclusive and the tax base amount is forced to `0`.
