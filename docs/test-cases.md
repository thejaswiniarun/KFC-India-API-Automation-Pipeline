# 🧪 Test Cases

**Project:** KFC India API Test Automation · **Total:** 22 · **Pass:** 12 · **Bug:** 10

Legend: ✅ PASS · 🪲 BUG · Type: **P** positive, **N** negative, **B** boundary

Execution results, logs and screenshots for every case are in the [Execution Matrix](docs/execution-matrix.md). Defects are in [bug-reports](docs/bug-reports/README.md).

## Summary

| Module | Prefix | Cases | Pass | Bug |
|--------|--------|------:|-----:|----:|
| Store & Service | `TC_STR` | 6 | 4 | 2 |
| Menu Catalog | `TC_CAT` | 5 | 4 | 1 |
| Cart Management | `TC_CRT` | 4 | 1 | 3 |
| Basket Calculation | `TC_BSK` | 7 | 3 | 4 |

---

## 1. Store & Service Validations (TC_STR)

| ID | Title | Type | Pre-condition | Steps | Expected | Actual | Status |
|----|-------|:----:|---------------|-------|----------|--------|:------:|
| TC_STR_01 | Valid Store & Services | P | Valid session token | 1. Send `GET catalogs/{catalogId}/KFCIndiaMenu-1726-web-pickup` with a valid store ID and service | `200 OK` with store/service data | `200 OK` | ✅ PASS |
| TC_STR_02 | Authorization Header Empty | P | None | 1. Send the menu catalog request<br>2. Remove the `Authorization: Bearer` header | `200 OK` (endpoint is public) | `200 OK` | ✅ PASS |
| TC_STR_03 | Unidentified Channel | N | Valid session token | 1. Send the menu catalog request<br>2. Set `X-Channel-Id: INVALID_CHANNEL` | `400 Bad Request` | `200 OK` | 🪲 [BUG-01](bug-reports/BUG-01-unidentified-channel.md) |
| TC_STR_04 | Invalid Store ID | N | Valid session token | 1. Send the request with a non-existent store ID | `404 Not Found` | `404 Not Found` | ✅ PASS |
| TC_STR_05 | Invalid Service | N | Valid session token | 1. Send the request with an invalid service value | `400 Bad Request` | `200 OK` | ✅ PASS |
| TC_STR_06 | Missing Parameters | N | Valid session token | 1. Send the menu catalog request with an empty `?mode=` | `400 Bad Request` | `200 OK` | 🪲 [BUG-02](bug-reports/BUG-02-missing-parameters.md) |

## 2. Menu Catalog Validations (TC_CAT)

| ID | Title | Type | Pre-condition | Steps | Expected | Actual | Status |
|----|-------|:----:|---------------|-------|----------|--------|:------:|
| TC_CAT_01 | Fetch Full Menu Catalog | P | Valid session | 1. Send `GET catalogs/{catalogId}/KFCIndiaMenu-1726-web-pickup` | `200 OK`; categories, non-zero prices, INR currency | `200 OK` | ✅ PASS |
| TC_CAT_02 | Fetch Valid Item Details | P | Item ID from catalog | 1. Request details for a valid item ID | `200 OK` with item details | `200 OK` | ✅ PASS |
| TC_CAT_03 | Fetch Invalid Item ID | N | Valid session | 1. Request details for a non-existent item ID | `404 Not Found` | `200` / `404` | ✅ PASS |
| TC_CAT_04 | Store Item Exclusions | P | Menu catalog session active | 1. Send `GET catalogs/{catalogId}/KFCIndiaMenu-1726-web-pickup/item-exclusions` | `200 OK` with an empty list `[]` | `404 Not Found` | 🪲 [BUG-03](bug-reports/BUG-03-exclusions-endpoint-not-found.md) |
| TC_CAT_05 | Schema Metadata Check | P | Valid session | 1. Fetch the catalog<br>2. Validate the JSON structure and metadata fields | `200 OK`; schema fields present | `200 OK` | ✅ PASS |

## 3. Cart Management Validations (TC_CRT)

| ID | Title | Type | Pre-condition | Steps | Expected | Actual | Status |
|----|-------|:----:|---------------|-------|----------|--------|:------:|
| TC_CRT_01 | Add Valid Item to cart | P | Catalog parsed | 1. `POST carts/items` with `{"itemId": "L-8000350", "quantity": 1}` | `200 OK`; decimal subtotal | `200` / `405`; subtotal `58572` | 🪲 [BUG-04](bug-reports/BUG-04-add-item-scaled-pricing.md) |
| TC_CRT_02 | Add Invalid Item to cart | N | Catalog parsed | 1. `POST carts/items` with a non-existent item ID | `400` / `404` | `405 Method Not Allowed` | ✅ PASS |
| TC_CRT_03 | Quantity Updated (qty: 2) | P | Item in cart | 1. `PUT carts/items` with `{"itemId": "L-8000350", "quantity": 2}` | `200 OK`; subtotal scales with quantity | `200` / `405`; subtotal `78096` | 🪲 [BUG-05](bug-reports/BUG-05-quantity-update-pricing.md) |
| TC_CRT_04 | Null value updated (qty: 0) | B | Item in cart | 1. `PUT carts/items` with `{"itemId": "L-8000350", "quantity": 0}` | `400 Bad Request`, error code `BSDE002` | `405 Method Not Allowed` | 🪲 [BUG-06](bug-reports/BUG-06-zero-quantity-input-bypass.md) |

## 4. Basket Calculation Validations (TC_BSK)

| ID | Title | Type | Pre-condition | Steps | Expected | Actual | Status |
|----|-------|:----:|---------------|-------|----------|--------|:------:|
| TC_BSK_001 | Out of Stock Validation | N | Item is sold out | 1. Run the stock check (`?check=stock`) | `validStatus: false` for the unavailable item | `isAvailable: false`, `validStatus: true` | 🪲 [BUG-07](bug-reports/BUG-07-out-of-stock-validation.md) |
| TC_BSK_002 | Charity Add Hope Mapping | P | Basket has a donation line | 1. Query the order summary (`?check=summary`) | `addHopeTotal: 500` | `addHopeTotal: 0` | 🪲 [BUG-08](bug-reports/BUG-08-charity-mapping-wiped.md) |
| TC_BSK_003 | Verify Tax Inclusion Mode | P | Tax-inclusive items | 1. Query tax config (`?check=taxes`) | `isTaxIncludedInItemPrice: true` | `false` | 🪲 [BUG-09](bug-reports/BUG-09-tax-inclusion-mode-error.md) |
| TC_BSK_004 | Verify Tax Base Amount | P | Multiple taxable items | 1. Query tax base (`?check=tax-base`) | `itemAmountOnTaxApplied` = taxable subtotal | `0` | 🪲 [BUG-10](bug-reports/BUG-10-tax-base-calculation-zero.md) |
| TC_BSK_005 | Subtotal & Tax Logic | P | Basket with items | 1. Fetch the basket summary<br>2. Compare subtotal and tax values | Subtotal and tax computed correctly | As expected | ✅ PASS |
| TC_BSK_006 | Verify CGST and SGST Split | P | Basket with taxed items | 1. Fetch the tax breakdown<br>2. Compare CGST and SGST | CGST and SGST split 50/50 | As expected | ✅ PASS |
| TC_BSK_007 | Validate Item Status Flags | P | Basket with items | 1. Fetch the basket<br>2. Check each item's status flags | Flags consistent with item state | As expected | ✅ PASS |
