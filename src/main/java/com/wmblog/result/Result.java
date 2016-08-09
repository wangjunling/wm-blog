package com.wmblog.result;

/**
 * Created by wangjunling on 2016/7/27.
 */
public class Result {
	private static final String SUCCESS = "success";

	private static final String ERROR = "error";

	private Meta meta;

	private Object data;

	public Result success() {
		this.meta = new Meta(true, SUCCESS);
		return this;
	}

	public Result success(Object data) {
		this.meta = new Meta(true, SUCCESS);
		this.data = data;
		return this;
	}

	public Result error() {
		this.meta = new Meta(true, ERROR);
		return this;
	}

	public Result error(String message) {
		this.meta = new Meta(true, message);
		return this;
	}

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	private class Meta {
		private boolean success;

		private String message;

		public Meta(boolean success) {
			this.success = success;
		}

		private Meta(boolean success, String message) {
			this.success = success;
			this.message = message;
		}

		public boolean isSuccess() {
			return success;
		}

		public void setSuccess(boolean success) {
			this.success = success;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
	}
}
