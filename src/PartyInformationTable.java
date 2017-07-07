import java.util.*;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PartyInformationTable {

		String defendant 	= ""; 
		String defenseatt 	= "";
		String plaintiff 	= ""; 
		String prosecatt	= "";

		
		public String getDefendantName(){
			return defendant;
		}
		public String getPlaintiffName(){
			return plaintiff;
		}
		public String getDefenseAttorney(){
			return defenseatt;
		}
		public String getProsecutingAttorney(){
			return prosecatt;
		}

		
		public PartyInformationTable(Element aTable){
			// Check that the table is the right one
			String caption= aTable.select("caption").text();
			assert caption == "Party Information";
			
			Elements rows = aTable.select("tr");
			
			for(Element tr : rows){
//				System.out.println(tr.text());
//				System.out.println(tr.childNodeSize());
				for (int i = 0; i < tr.childNodeSize(); i++) {
					if (tr.child(i).text().equals("Defendant")) {
						defendant = tr.child(i+1).text();
						defenseatt = tr.child(tr.childNodeSize() - 1).text();
						System.out.println("Defendant: " + defendant);
						System.out.println("DefenseAtt: " + defenseatt);
					}
					else if (tr.child(i).text().equals("Plaintiff")) {
						plaintiff = tr.child(i+1).text();
						prosecatt = tr.child(tr.childNodeSize() - 1).text();
						System.out.println("Plaintiff: " + plaintiff);
						System.out.println("ProsecAtt: " + prosecatt);
					}
				}
			}
		}


}
