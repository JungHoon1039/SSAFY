package com.ssafy.ws.model.dto;

import org.springframework.web.multipart.MultipartFile;

public class Restaurant {
	/** 맛집Id */
	private int resId;
	/** 맛집이름 */
	private String resName;
	/** 맛집주소 */
	private String resAddress;
	/** 맛집시그니쳐메뉴 */
	private String signatureMenu;
	/** 별점 */
	private int resRate;
	/** 파일 원래 이름 */
	private String fileName;
	/** 파일 저장 경로 */
	private String fileUri;

	private MultipartFile file;

	public Restaurant() {

	}

	public Restaurant(int resId, String resName, String resAddress, String signatureMenu, int resRate) {
		super();
		this.resId = resId;
		this.resName = resName;
		this.resAddress = resAddress;
		this.signatureMenu = signatureMenu;
		this.resRate = resRate;
	}

	public Restaurant(String resName, String resAddress, String signatureMenu, int resRate) {
		this.resName = resName;
		this.resAddress = resAddress;
		this.signatureMenu = signatureMenu;
		this.resRate = resRate;
	}

	/**
	 * 맛집 Id를 반환한다.
	 * 
	 * @return 맛집 Id
	 */
	public int getResId() {
		return resId;
	}

	/**
	 * 맛집 Id를 저장한다.
	 * 
	 * @param resId : 맛집 Id
	 */
	public void setResId(int resId) {
		this.resId = resId;
	}

	/**
	 * 맛집 이름을 반환한다.
	 * 
	 * @return 맛집 이름
	 */
	public String getResName() {
		return resName;
	}

	/**
	 * 맛집 이름을 저장한다.
	 * 
	 * @param resName : 맛집 이름
	 */
	public void setResName(String resName) {
		this.resName = resName;
	}

	/**
	 * 맛집 주소를 반환한다.
	 * 
	 * @return 맛집 주소
	 */
	public String getResAddress() {
		return resAddress;
	}

	/**
	 * 맛집 주소를 저장한다.
	 * 
	 * @param resAddress : 맛집 주소
	 */
	public void setResAddress(String resAddress) {
		this.resAddress = resAddress;
	}

	/**
	 * 맛집 시그니쳐메뉴를 반환한다.
	 * 
	 * @return 맛집 시그니쳐메뉴
	 */
	public String getSignatureMenu() {
		return signatureMenu;
	}

	/**
	 * 맛집 시그니쳐메뉴를 저장한다.
	 * 
	 * @param signatureMenu : 맛집 시그니쳐메뉴
	 */
	public void setSignatureMenu(String signatureMenu) {
		this.signatureMenu = signatureMenu;
	}

	/**
	 * 맛집 별점을 반환한다.
	 * 
	 * @return 맛집 별점
	 */
	public int getResRate() {
		return resRate;
	}

	/**
	 * 맛집 별점을 저장한다.
	 * 
	 * @param resRate : 맛집 별점
	 */
	public void setResRate(int resRate) {
		this.resRate = resRate;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileUri() {
		return fileUri;
	}

	public void setFileUri(String fileUri) {
		this.fileUri = fileUri;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "Restaurant [resId=" + resId + ", resName=" + resName + ", resAddress=" + resAddress + ", signatureMenu="
				+ signatureMenu + ", resRate=" + resRate + ", fileName=" + fileName + ", fileUri=" + fileUri + ", file="
				+ file + "]";
	}

	
}
