package jpabook.jpashop.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class UpdateMemberResponse {
    private Long id;
    private String name;
}
