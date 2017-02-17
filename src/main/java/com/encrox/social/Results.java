package com.encrox.social;

public class Results {
	
	public static class Party {
		
		public static class Add {
			
			public static final byte OK = 0;
			public static final byte LIMIT = 1;
			
		}
		
		public static class Remove {
			
			public static final byte OK = 0;
			public static final byte NOT_EXIST = 1;
			
		}
		
		public static class Op {
			
			public static final byte OK = 0;
			public static final byte NOT_IN_PARTY = 1;
			public static final byte ALREADY_OP = 2;
			
		}
		
		public static class Deop {
			
			public static final byte OK = 0;
			public static final byte NOT_IN_PARTY = 1;
			public static final byte NOT_OP = 2;
			
		}
		
	}

}
