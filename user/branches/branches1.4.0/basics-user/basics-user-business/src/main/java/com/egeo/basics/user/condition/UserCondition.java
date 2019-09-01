package com.egeo.basics.user.condition;

import com.egeo.basics.user.po.UserPO;

/**
 * 
 * @author xiaping
 * @date 2017-05-15 15:45:26
 */
public class UserCondition extends UserPO {
	private static final long serialVersionUID = 1L;
	private Long uxId;

        /**
         * 性别
         */
        private Integer sex;

        /**
         * 昵称
         */
        private String nickname;

        /**
         * 头像
         */
        private String headPicUrl;

        /**
         * 
         */
        private String name;
        
        public Long getUxId() {
            return uxId;
        }

        public void setUxId(Long uxId) {
            this.uxId = uxId;
        }

        public Integer getSex() {
            return sex;
        }

        public void setSex(Integer sex) {
            this.sex = sex;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getHeadPicUrl() {
            return headPicUrl;
        }

        public void setHeadPicUrl(String headPicUrl) {
            this.headPicUrl = headPicUrl;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

}
	