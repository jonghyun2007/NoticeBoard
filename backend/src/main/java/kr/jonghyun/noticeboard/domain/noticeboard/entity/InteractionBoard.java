package kr.jonghyun.noticeboard.domain.noticeboard.entity;

import jakarta.persistence.*;
import kr.jonghyun.noticeboard.domain.user.entity.User;
import kr.jonghyun.noticeboard.global.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "interaction_boards")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InteractionBoard extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id")
    private User author;
    private String contents;

}
