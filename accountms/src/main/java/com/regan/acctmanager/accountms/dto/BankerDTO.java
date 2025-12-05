package com.regan.acctmanager.accountms.dto;

import java.util.UUID;

public record BankerDTO( UUID sysUUID,

         String customer_id,

         String bank_name,

         String ifsc_code,

         String branch) {
}
