package com.ssafy.ws.model;

public enum User {
	USER_SEQ{
		public String toString() {
			return "userSeq";
		}
	},
	USER_ID{
		public String toString() {
			return "userId";
		}
	},
	USER_PWD{
		public String toString() {
			return "userPwd";
		}
	},
	USER_NAME{
		public String toString() {
			return "userName";
		}
	},
	NICK_NAME{
		public String toString() {
			return "nickname";
		}
	},
	EMAIL{
		public String toString() {
			return "email";
		}
	},
	USER_RANK{
		public String toString() {
			return "userRank";
		}
	},
	JOINED_AT{
		public String toString() {
			return "joinedAt";
		}
	};
}
