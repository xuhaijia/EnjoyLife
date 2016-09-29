package com.lanou.xuhaijia.enjoylife.picture.comment;

import java.util.List;

/**
 * 　　　　　　　　┏┓　　　┏┓+ +
 * 　　　　　　　┏┛┻━━━┛┻┓ + +
 * 　　　　　　　┃　　　　　　　┃
 * 　　　　　　　┃　　　━　　　┃ ++ + + +
 * 　　　　　　 ████━████ ┃+
 * 　　　　　　　┃　　　　　　　┃ +
 * 　　　　　　　┃　　　┻　　　┃
 * 　　　　　　　┃　　　　　　　┃ + +
 * 　　　　　　　┗━┓　　　┏━┛
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃ + + + +
 * 　　　　　　　　　┃　　　┃　　　　Code is far away from bug with the animal protecting
 * 　　　　　　　　　┃　　　┃ + 　　　　神兽保佑代码无BUG,
 * <p/>
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃　　+
 * 　　　　　　　　　┃　 　　┗━━━┓ + +
 * 　　　　　　　　　┃ 　　　　　　　┣┓
 * 　　　　　　　　　┃ 　　　　　　　┏┛
 * 　　　　　　　　　┗┓┓┏━┳┓┏┛ + + + +
 * 　　　　　　　　　　┃┫┫　┃┫┫
 * 　　　　　　　　　　┗┻┛　┗┻┛+ + + +
 * <p/>
 * Created by 史静雯 date
 */
public class CommentBean {

    /**
     * has_next : 0
     * comments : [{"content":"聘文字录入   员在家可做\n\n5000字100元一万字200元\n\n以此  类推，工銭每天一结\n\n在校学生和在家带宝宝的\n\n每天日收80-300元不等\n\n详情请加  微  信  84483634","created_at":1474929982000,"id":4399,"author":{"username":"一颗想和你飞的心  宝贝儿","avatar_url":"http://q.qlogo.cn/qqapp/1105321739/D607D9F8FC4F448BC0ACCDB31B25A770/100","id":59571,"sign":"遇见最美的自己"}}]
     */

    private DataBean data;
    /**
     * data : {"has_next":0,"comments":[{"content":"聘文字录入   员在家可做\n\n5000字100元一万字200元\n\n以此  类推，工銭每天一结\n\n在校学生和在家带宝宝的\n\n每天日收80-300元不等\n\n详情请加  微  信  84483634","created_at":1474929982000,"id":4399,"author":{"username":"一颗想和你飞的心  宝贝儿","avatar_url":"http://q.qlogo.cn/qqapp/1105321739/D607D9F8FC4F448BC0ACCDB31B25A770/100","id":59571,"sign":"遇见最美的自己"}}]}
     * result : 1
     */

    private int result;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public static class DataBean {
        private int has_next;
        /**
         * content : 聘文字录入   员在家可做

         5000字100元一万字200元

         以此  类推，工銭每天一结

         在校学生和在家带宝宝的

         每天日收80-300元不等

         详情请加  微  信  84483634
         * created_at : 1474929982000
         * id : 4399
         * author : {"username":"一颗想和你飞的心  宝贝儿","avatar_url":"http://q.qlogo.cn/qqapp/1105321739/D607D9F8FC4F448BC0ACCDB31B25A770/100","id":59571,"sign":"遇见最美的自己"}
         */

        private List<CommentsBean> comments;

        public int getHas_next() {
            return has_next;
        }

        public void setHas_next(int has_next) {
            this.has_next = has_next;
        }

        public List<CommentsBean> getComments() {
            return comments;
        }

        public void setComments(List<CommentsBean> comments) {
            this.comments = comments;
        }

        public static class CommentsBean {
            private String content;
            private long created_at;
            private int id;
            /**
             * username : 一颗想和你飞的心  宝贝儿
             * avatar_url : http://q.qlogo.cn/qqapp/1105321739/D607D9F8FC4F448BC0ACCDB31B25A770/100
             * id : 59571
             * sign : 遇见最美的自己
             */

            private AuthorBean author;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public long getCreated_at() {
                return created_at;
            }

            public void setCreated_at(long created_at) {
                this.created_at = created_at;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public AuthorBean getAuthor() {
                return author;
            }

            public void setAuthor(AuthorBean author) {
                this.author = author;
            }

            public static class AuthorBean {
                private String username;
                private String avatar_url;
                private int id;
                private String sign;

                public String getUsername() {
                    return username;
                }

                public void setUsername(String username) {
                    this.username = username;
                }

                public String getAvatar_url() {
                    return avatar_url;
                }

                public void setAvatar_url(String avatar_url) {
                    this.avatar_url = avatar_url;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getSign() {
                    return sign;
                }

                public void setSign(String sign) {
                    this.sign = sign;
                }
            }
        }
    }
}
