package com.gakki.love.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 评论回复.
 * Created by 林漠 on 2017/6/6.
 */
@Cacheable
@Entity
@Data
public class Reply {

    /** The id. */
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /** 回复内容. */
    @Column(nullable = false)
    private String content;

    /** 时间. */
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date date;

    /** 回复的评论. */
    @ManyToOne()
    @JoinColumn(name = "comment", nullable = false)
    private Comment comment;

    /** 回复的用户. */
    @OneToOne
    @JoinColumn(name = "user", nullable = false)
    private User user;

    @Override
    public String toString() {
        return "Reply{" + "id=" + id + ", content='" + content + '\'' + ", date=" + date + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;

        Reply reply = (Reply) o;

        if (id != null ? !id.equals(reply.id) : reply.id != null)
            return false;
        if (content != null ? !content.equals(reply.content) : reply.content != null)
            return false;
        return date != null ? date.equals(reply.date) : reply.date == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
