package com.gakki.love.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**反馈
 *
 * Created by 林漠 on 2017/6/6.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedBack{
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user")
    private User user;
    @Column
    private String content;
    @Column
    private Date date;
    @Column
    private String hasCheck;

    @Override
    public String toString() {
        return "FeedBack{" + "id=" + id + ", content='" + content + '\'' + ", date=" + date + ", hasCheck='" + hasCheck
                + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;

        FeedBack feedBack = (FeedBack) o;

        if (id != null ? !id.equals(feedBack.id) : feedBack.id != null)
            return false;
        if (content != null ? !content.equals(feedBack.content) : feedBack.content != null)
            return false;
        if (date != null ? !date.equals(feedBack.date) : feedBack.date != null)
            return false;
        return hasCheck != null ? hasCheck.equals(feedBack.hasCheck) : feedBack.hasCheck == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (hasCheck != null ? hasCheck.hashCode() : 0);
        return result;
    }
}
