package com.jin.Membership;


	// 우편번호 
	public class Zipcode {

	    // 구역번호 
	    
	    private String zipcode;

	    // 시도 
	    
	    private String sido;

	    // 시군구 
	    
	    private String sigungu;

	    // 읍면 
	    
	    private String ubmyeun;

	    // 도로명 
	    
	    private String doro;

	    // 행정동명 
	    
	    private String dong;

	    public String getZipcode() {
	        return zipcode;
	    }

	    public void setZipcode(String zipcode) {
	        this.zipcode = zipcode;
	    }

	    public String getSido() {
	        return sido;
	    }

	    public void setSido(String sido) {
	        this.sido = sido;
	    }

	    public String getSigungu() {
	        return sigungu;
	    }

	    public void setSigungu(String sigungu) {
	        this.sigungu = sigungu;
	    }

	    public String getUbmyeun() {
	        return ubmyeun;
	    }

	    public void setUbmyeun(String ubmyeun) {
	        this.ubmyeun = ubmyeun;
	    }

	    public String getDoro() {
	        return doro;
	    }

	    public void setDoro(String doro) {
	        this.doro = doro;
	    }

	    public String getDong() {
	        return dong;
	    }

	    public void setDong(String dong) {
	        this.dong = dong;
	    }

	    // Zipcode 모델 복사
	    public void CopyData(Zipcode param)
	    {
	        this.zipcode = param.getZipcode();
	        this.sido = param.getSido();
	        this.sigungu = param.getSigungu();
	        this.ubmyeun = param.getUbmyeun();
	        this.doro = param.getDoro();
	        this.dong = param.getDong();
	    }
	}

