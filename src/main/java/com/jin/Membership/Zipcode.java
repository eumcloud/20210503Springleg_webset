package com.jin.Membership;


	// �����ȣ 
	public class Zipcode {

	    // ������ȣ 
	    
	    private String zipcode;

	    // �õ� 
	    
	    private String sido;

	    // �ñ��� 
	    
	    private String sigungu;

	    // ���� 
	    
	    private String ubmyeun;

	    // ���θ� 
	    
	    private String doro;

	    // �������� 
	    
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

	    // Zipcode �� ����
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

