package ktp.extractor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Extractor {
	private String output;
	
	private String provinsi;
	private String kota;
	private String nik;
	private String nama;
	private String ttl;
	private String jk;
	private String gol;
	private String alamat;
	private String rtrw;
	private String kel;
	private String kec;
	private String agama;
	private String status;
	private String kerja;
	private String kewarnegaraan;
	private String berlaku;
	
	private Matcher matcher;
	private Pattern pattern;
	private String[] temp;
	
	public String extract(String input){
		String[] sentences = input.split("\n");
		
		int index = 0;
		provinsi = sentences[index++].split(" ", 2)[1];
		kota = sentences[index++].split(" ", 2)[1];
		nik = sentences[index++].split(" ")[1];
		
		nama = sentences[index++].split(" ", 2)[1];
		if(!(sentences[index].charAt(0)== 'T' && sentences[index].charAt(1)== 'e') && sentences[index].length() < 30){
			nama += " " + sentences[index++];
		}
		
		temp = sentences[index++].split(" ");
		ttl = temp[2];
				
		if(sentences[index].length() > 30){
			ttl += ", " + temp[3];
		} else {
			ttl += ", " + sentences[index++];
		}
		
		temp = sentences[index++].split(" ");
		jk = temp[2];
		gol = temp[5];
		
		alamat = sentences[index++].split(" ", 2)[1];
		
		pattern = Pattern.compile("\\/");
		matcher = pattern.matcher(sentences[index]);
		if(!(sentences[index].charAt(0) == 'R' && sentences[index].charAt(1)=='T') && !matcher.find()){
			alamat += " " + sentences[index++];
		}
		
		rtrw = sentences[index++].split(" ", 2)[1];
		kel = sentences[index++].split(" ", 2)[1];
		kec = sentences[index++].split(" ", 2)[1];
		agama = sentences[index++].split(" ", 2)[1];
		status = sentences[index++].split(" ",3)[2];
		kerja = sentences[index++].split(" ", 2)[1];
		kewarnegaraan = sentences[index++].split(" ")[1];
		berlaku = sentences[index].split(" ", 3)[2];
		
		output = "PROVINSI : " + provinsi + "\nKOTA/KABUPATEN : " + kota + "\nNIK : " + nik + "\nNama : " + nama + "\nTempat/Tgl Lahir : " +
				ttl + "\nJenis Kelamin : " + jk + "\nGol. Darah : " + gol + "\nAlamat : " + alamat + "\nRT/RW : " + rtrw +
				"\nKel/Desa : " + kel + "\nKecamatan : " + kec + "\nAgama : " + agama + "\nStatus Perkawinan : " + status +
				"\nPekerjaan : " + kerja + "\nKewarnegaraan : " + kewarnegaraan + "\nBerlaku Hingga : " + berlaku;
		
		return output;
	}
}
