package model;

public class IRVE {
	private String nomEnseigne;
	private String adresse;
	private String coordonneesXY;
	private float puissanceNominal;
	private boolean priseTypeEf;
	private boolean priseType2;
	private boolean priseTypeComboCs;
	private boolean priseTypeChademo;
	private boolean priseTypeAutre;
	
	public double lat;
    public double lng;
	
	//Constructeur
	public IRVE(double lat, double lng, String nomEnseigne,String adresse, String coordonneesXY, float puissanceNominal, boolean priseTypeEf, boolean priseType2, boolean priseTypeComboCs, boolean priseTypeChademo, boolean priseTypeAutre) {
		this.nomEnseigne=nomEnseigne;
		this.adresse = adresse;
		this.coordonneesXY = coordonneesXY;
		this.puissanceNominal = puissanceNominal;
		this.priseTypeEf = priseTypeEf;
		this.priseType2 = priseType2;
		this.priseTypeComboCs = priseTypeComboCs;
		this.priseTypeChademo = priseTypeChademo;
		this.priseTypeAutre = priseTypeAutre;
		
        this.lat = lat;
        this.lng = lng;
	}
	
	//Getters
	public double getLat() {
		return lat;
	}

	public double getLng() {
		return lng;
	}

	public String getNomEnseigne() {
		return nomEnseigne;
	}
	
	public String getAdresse() {
		return adresse;
	}
	
	public String getCoordonneesXY() {
		return coordonneesXY;
	}
	
	public float getPuissanceNominal() {
		return puissanceNominal;
	}
	
	public boolean getPriseTypeEf() {
		return priseTypeEf;
	}
	
	public boolean getPriseType2() {
		return priseType2;
	}
	
	public boolean getPriseTypeComboCs() {
		return priseTypeComboCs;
	}
	
	public boolean getPriseTypeChademo() {
		return priseTypeChademo;
	}
	
	public boolean getPriseTypeAutre() {
		return priseTypeAutre;
	}
	
	// Setters
	public void setLat(double lat) {
		this.lat = lat;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}
	
    public void setNomEnseigne(String nomEnseigne) {
        this.nomEnseigne = nomEnseigne;
    }
    
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
    public void setCoordonneesXY(String coordonneesXY) {
        this.coordonneesXY = coordonneesXY;
    }
    
    public void setPuissanceNominal(float puissanceNominal) {
        this.puissanceNominal = puissanceNominal;
    }
    
    public void setPriseTypeEf(boolean priseTypeEf) {
        this.priseTypeEf = priseTypeEf;
    }
    
    public void setPriseType2(boolean priseType2) {
        this.priseType2 = priseType2;
    }
    
    public void setPriseTypeComboCs(boolean priseTypeComboCs) {
        this.priseTypeComboCs = priseTypeComboCs;
    }
    
    public void setPriseTypeChademo(boolean priseTypeChademo) {
        this.priseTypeChademo = priseTypeChademo;
    }
    
    public void setPriseTypeAutre(boolean priseTypeAutre) {
        this.priseTypeAutre = priseTypeAutre;
    }
}
