package Day06;

import java.util.Scanner;

public class Day06_3 {
	// È¸¿øÁ¦ ÇÁ·Î±×·¥ [Å¬·¡½º]
	
		// 0. È¸¿ø ¼³°è -> È¸¿ø Å¬·¡½º ¸¸µé±â
			// 1. ÇÊµå (³ªÁß¿¡ »ı¼ºÀÚ, ¸Ş¼Òµåµµ Ãß°¡ÇÏ°Ô µÉ °Í..¹è¿ì¸é. ±×·³ ´õ  ÆíÇØÁü)
				// ÇÊµå´Â ³×ÀÌ¹ö Âü°í (°´Ã¼¿¡ ÀúÀåÇÒ µ¥ÀÌÅÍ)
				// 1. ¾ÆÀÌµğ 2. ºñ¹Ğ¹øÈ£ 3. ÀÌ¸§ 4. ÀüÈ­¹øÈ£
		// 1. ÃÊ±â¸Ş´º [1. È¸¿ø°¡ÀÔ 2. ·Î±×ÀÎ 3.¾ÆÀÌµğÃ£±â 4.ºñ¹Ğ¹øÈ£ ¯G°¡]
			// 1. È¸¿ø°¡ÀÔ½Ã  ÀÔ·Â ¹Ş¾Æ ÀúÀå -> ¾ÆÀÌµğ, ºñ¹Ğ¹øÈ£
			// 2. ·Î±×ÀÎ½Ã ¾ÆÀÌµğ¿Í ºñ¹Ğ¹øÈ£°¡ µ¿ÀÏÇÏ¸é ·Î±×ÀÎ Ã³¸®
			// 3. ¾ÆÀÌµğ Ã£±â´Â ÀÌ¸§°ú ÀüÈ­¹øÈ£°¡ µ¿ÀÏÇÏ¸é ¾ÆÀÌµğ Ãâ·Â
			// 4. ºñ¹Ğ¹øÈ£ Ã£±â´Â ¾ÆÀÌµğ¿Í ÀüÈ­¹øÈ£°¡ µ¿ÀÏÇÏ¸é Ãâ·Â
	
	public static void main(String[] args) {
	
		// À§¿¡ ¼±¾ğÇÏ´Â ÀÌÀ¯ : main¸Ş¼Òµå¸¦ ¸ğµç °÷¿¡¼­ »ç¿ëÇÏ±â À§ÇØ¼­.
						// Áö¿ª º¯¼ö´Â {}¸¦ ³ª°¡¸é ¼Ò¸êµÈ´Ù.
		
			Scanner scanner = new Scanner(System.in);
			Member[] memberlist = new Member[100];	// 1Â÷¿ø ¹è¿­
			// ¸¸¾à¿¡ Å¬·¡½º°¡ ¾øÀ» °æ¿ì¿¡´Â**String[][] memberlist = new Member[100][4]·Î 2Â÷¿ø ¹è¿­À» »ç¿ëÇÑ´Ù.
			// ÇöÀç °´Ã¼·Î ¹­¿´±â ¶§¹®¿¡ 2Â÷ ¹è¿­ »ç¿ëÇÏÁö ¾Ê¾Æµµ µÈ´Ù.
			// Member Å¬·¡½º·Î ¸¸µé¾îÁø °´Ã¼(4°³) 100°³¸¦ ÀúÀåÇÒ ¼ö ÀÖ´Â ¹è¿­À» Ç¥ÇöÇÑ °Í. =ÃÑ 400°³
			
		while(true) { //ÇÁ·Î±×·¥ ½ÇÇà while start

			System.out.println("-----------------È¸¿øÁ¦[Å¬·¡½º]-----------------");
			System.out.println("1.È¸¿ø°¡ÀÔ 2.·Î±×ÀÎ 3.¾ÆÀÌµğ Ã£±â 4.ºñ¹Ğ¹øÈ£ Ã£±â");
			System.out.println(" ¼±ÅÃ : "); int ch = scanner.nextInt();
			
			//Å¬·¡½º¿¡ ¸Ş¸ğ¸® ÇÒ´çÇÒ¶§ ¹İµå½Ã new 
			
			if(ch == 1) { // È¸¿ø°¡ÀÔ
				// 1. id, pw, name, phone ÀÔ·Â ¹Ş±â -> º¯¼ö 4°³
				System.out.println("---------------È¸¿ø°¡ÀÔ ÆäÀÌÁö---------------");
				System.out.println("¾ÆÀÌµğ : "); String id = scanner.next();
				System.out.println("ºñ¹Ğ¹øÈ£ : "); String pw = scanner.next();
				System.out.println("ÀÌ¸§ : "); String name = scanner.next();
				System.out.println("ÀüÈ­¹øÈ£ : "); String phone = scanner.next();
			
				// 2. µû·Îµû·Î ¹­´Â°Ô ¾Æ´Ï¶ó Å¬·¡½º, °´Ã¼¿¡°Ô ÀúÀå.
				Member member = new Member();
				// member Å¬·¡½ºÀÇ ¸â¹ö¸¦ ¸¸µé°í ´º ¸â¹ö¸¦ ÇÏ³ª ´õ ¸¸µç´Ù.
				// È¸¿ø 1¸í´ç member ÇÏ³ª. ¿©·¯°³ ¸¸µé±â ¶§¹®¿¡ À§¿¡ ¹è¿­À» »ı¼ºÇÑ´Ù.
				
				// 3. ÀÔ·Â ¹ŞÀº º¯¼ö 4°³¸¦ °´Ã¼ ³» ÇÊµå¿¡ ÀúÀåÇÏ±â
				member.id = id; //ÀÔ·Â ¹ŞÀº °É Áı¾î³Ö´Â´Ù.
				// °´Ã¼ ³» ÇÊµå = ÀÔ·Â ¹ŞÀº °ªÀ» ³Ö¾îÁØ´Ù. Â÷°îÂ÷°î~
				member.pw = pw; member.name = name;	member.phone = phone;
				
				// * ¾ÆÀÌµğ Áßº¹Ã¼Å©
					// 1.¹è¿­ ³» °´Ã¼ Áß ÀÔ·ÂÇÑ ¾ÆÀÌµğ¿Í µ¿ÀÏÇÑ ¾ÆÀÌµğ Ã£±â
				boolean idcheck = false; //ÀÏÁ¾ÀÇ ½ºÀ§Ä¡¹öÆ°
				for(Member temp : memberlist) {
					//¸ğµç °´Ã¼¸¦ ÇÏ³ª¾¿ ²¨³»¿Í ºñ±³. ³»°¡ ÀÔ·ÂÇÑ ¾ÆÀÌµğequals °°À¸¸é Áßº¹
					// memberlist ¹è¿­ ³» °´Ã¼µéÀ» ÇÏ³ª¾¿ temp¿¡ ´ëÀÔ ¹İº¹
					if (temp != null && temp.id.equals(id)) {
						//temp°¡ nullÀÌ ¾Æ´Ò¶§,
						//¸¸ÀÏ ÇØ´ç °´Ã¼ ³» ¾ÆÀÌµğ°¡ ÀÔ·Â ¹ŞÀº ¾ÆÀÌµğ¿Í °°À¸¸é
						System.err.println("¾Ë¸²) »ç¿ë ÁßÀÎ ¾ÆÀÌµğÀÔ´Ï´Ù."); //¼ÛÃâ
						idcheck = true;
						break; 
					}
				}
				
				// ¾ÆÀÌµğ°¡ Áßº¹ÀÌ ¾øÀ» °æ¿ì ÀúÀå (Áßº¹ ÀÖ´Ù ¾ø´Ù¸¸ ³Ö´Â°ÍÀÌ¹Ç·Î boolean.
				// Áßº¹ÀÌ ¾È °É¸®¸é false Áßº¹ÀÌ¸é true)
				if (idcheck = false); {
					//Áßº¹ÀÌ ¾øÀ» °æ¿ì¿¡ ¼ÛÃâ
					
				// 4. ¿©·¯°³ °´Ã¼¸¦ ÀúÀåÇÏ´Â ¹è¿­¿¡ ÀúÀå (¹İº¹)
					// 1. ¹«ÀÛÁ¤ ÀúÀåÇÏÁö ¸»°í °ø¹é ÀÎµ¦½º¸¦ Ã£¾Æ¼­ °ø¹é ÀÎµ¦½º¿¡ °´Ã¼ ÀúÀå
					// ±×·¸Áö ¾ÊÀ¸¸é µ¤¾î¾º¿ì±â°¡ µÇ¾î ±âÁ¸ ÀÔ·Â°ªÀÌ »ç¶óÁö¹Ç·Î ¹İµå½Ã °ø¹é Ã£À»°Í
				int i= 0; //ÀÎµ¦½º À§Ä¡ º¯¼ö;
				for( Member temp : memberlist ) { //tempÀÌ¸§Àº ¾Æ¹«°Å³ª. for¹®ÀÇ È°¿ë
					//memberlist ¹è¿­ ³» member °´Ã¼ ÇÏ³ª¾¿ ²¨³»¿Í¼­ temp¿¡ ÀúÀå ¹İº¹
					if (temp == null) { //¸¸ÀÏ temp°¡ nullÀÌ¸é ÇØ´ç ÀÎµ¦½º¿¡ »õ·Î ¸¸µé¾îÁø °´Ã¼¸¦ ÀúÀåÇÑ´Ù.
						memberlist[i] = member; 
						System.out.println("¾Ë¸²) È¸¿ø°¡ÀÔ ¼º°ø");
						break; //for¹® ³ª°¡±â. ³ª°¡Áö ¾ÊÀ¸¸é ¸ğµç °ø¹é¿¡ µ¿ÀÏÇÑ °´Ã¼°¡ ÀúÀåµÊ
				} i++; //ÀÎµ¦½º Áõ°¡			
			} // for¹® ³¡
		} //¾ÆÀÌµğ Ã¼Å©
		} // ch1 if ³¡, È¸¿ø°¡ÀÔ end
			
			
			else if(ch == 2) {// ·Î±×ÀÎ
				// 1. ÀÔ·Â ¹Ş±â
				System.out.println("----------------·Î±×ÀÎ ÆäÀÌÁö----------------");
				System.out.println("¾ÆÀÌµğ : "); String loginid = scanner.next();
				System.out.println("ºñ¹Ğ¹øÈ£ : "); String loginpw = scanner.next();
				// memberlist ¾È¿¡ ÀÔ·Â ¹Ş¾Æ¼­ ÀúÀåÇÑ Member °´Ã¼ ¾È ¾îµğ¿¡ ÀÖ´ÂÁö¸¦ Ã£¾Æ¾ßÇÔ
				// ÇÏ³ª¾¿ ºñ±³, Áï equals
				
				// 2. ±âÁ¸ ¹è¿­ [È¸¿ø¸®½ºÆ®]³» ÀÔ·Â ¹ŞÀº °ª°ú ºñ±³
				boolean loginchek = false; // ture:·Î±×ÀÎ ¼º°ø false:·Î±×ÀÎ ½ÇÆĞ·Î ¹İº¹ÇÒ ¸ñÀû
				//·Î±×ÀÎ Çß´ÂÁö ¾È Çß´ÂÁö ¹İµå½Ã ±â·ÏÀ» ³²°Ü¾ßÇÑ´Ù. ·Î±ä Ã¼Å©¸¦ ¸¸µé¾î¼­ ½ÇÆĞ ¸¸µé¾î³õ°í ¼º°ø¶õ¿¡ true·Î ¼º°øÇ¥½Ã ³²±â±â
				for(Member temp : memberlist) {
					// memberlist ³» 0¹ø ÀÎµ¦½ººÎÅÍ ³¡ ÀÎµ¦½º±îÁö ÇÏ³ª¾¿ temp¿¡ ´ëÀÔ
					// temp°¡ nullÀÌ ¾Æ´Ñ °æ¿ì Ãß°¡. nullÀÌ ¾Æ´Ò ¶§¸¸ equals¸¦ ÇÑ´Ù´Â ÄÚµå
					if( temp != null && temp.id.equals(loginid) && temp.pw.equals(loginpw)) {
						System.out.println("¾Ë¸²) ·Î±×ÀÎ ¼º°ø"); loginchek = true; } //·Î±×ÀÎ ¼º°øÇß´Ù´Â ±â·Ï ³²±â±â
				} // for end
				
				//3. ·Î±×ÀÎ ¼º°ø À¯¹«
				if (loginchek == false) {System.out.println("¾Ë¸²)µ¿ÀÏÇÑ È¸¿øÁ¤º¸°¡ ¾ø½À´Ï´Ù.");	}
				// À§ÀÇ booleanÀÌ ¿©±â·Î µµÂø. trueÀÏ °æ¿ì Áö³ª°¨				
			} //·Î±×ÀÎ end
			
			
			else if(ch == 3) {// ¾ÆÀÌµğ Ã£±â
					// 1. ÀÌ¸§°ú ¿¬¶ôÃ³¸¦ ÀÔ·Â ¹Ş´Â´Ù.
				System.out.println("----------¾ÆÀÌµğ Ã£±â----------");
				System.out.println("ÀÌ¸§ : "); String name = scanner.next();
				System.out.println("¿¬¶ôÃ³ : "); String phone = scanner.next();
				
					// 2. ¹è¿­³» µ¿ÀÏÇÑ ÀÌ¸§°ú ¿¬¶ôÃ³°¡ ÀÖ´ÂÁö È®ÀÎÇÑ´Ù. (·Î±×ÀÎ°ú À¯»ç)
				boolean findcheck = false;
				for(Member temp : memberlist) { //Member ÀÚ¸®¿¡´Â ¹è¿­ÀÇ ÀÚÀ¯ÇüÀÌ µé¾î°¡¾ßÇÑ´Ù. string=x
					// temp°¡ °ø¹éÀÌ ¾Æ´Ï¸é¼­ -
					if(temp != null && temp.name.equals(name) && temp.phone.equals(phone)) ;				
					// 3. µ¿ÀÏÇÑ °´Ã¼°¡ ÀÖÀ¸¸é ÇØ´ç ¾ÆÀÌµğ Ãâ·Â
					{ System.err.println("¾Ë¸²) ¾ÆÀÌµğ Ã£±â ¼º°ø");
					System.out.println("È¸¿ø ID : " + temp.id);
					findcheck = true;
					break;
					}//if end
				} // for end
				
				// ¾ÆÀÌµğ Ã£±â ¼º°ø, ½ÇÆĞ¸¦ ÀúÀåÀ» À§ÇØ¼­ boolean
				
					// 4. ¾øÀ¸¸é ¾ø´Ù°í Ãâ·Â
				if ( findcheck == false ) {
					System.err.println("¾Ë¸²) µ¿ÀÏÇÑ È¸¿ø Á¤º¸°¡ ¾ø½À´Ï´Ù. ");
				}
			}
			
			
			else if(ch == 4) {// ºñ¹Ğ¹øÈ£ Ã£±â
				System.out.println("¾ÆÀÌµğ : "); String id = scanner.next();
				System.out.println("ÀüÈ­¹øÈ£ : "); String phone = scanner.next();
				boolean findcheck = false;
				for ( Member temp : memberlist) {
					if(temp != null && temp.equals(id) && temp.equals(phone)) {
						System.out.println("¾Ë¸²) ºñ¹Ğ¹øÈ£ Ã£±â ¼º°ø");
						System.out.println("È¸¿ø ºñ¹Ğ¹øÈ£ : " + temp.pw);
						findcheck = true; // Ã£¾ÒÀ¸¸é true º¯°æ. Ã£¾Ò´Ù´Â ±â·Ï
						break;
					}
				}
				if (findcheck = false) {
					System.out.println("¾Ë¸²) µ¿ÀÏÇÑ È¸¿ø Á¤º¸°¡ ¾ø½À´Ï´Ù.");
				}
			} // ch4 else if end
			else { System.err.println("¾Ë ¼ö ¾ø´Â ¹øÈ£ÀÔ´Ï´Ù.");} 	
		} //ÇÁ·Î±×·¥ ½ÇÇà while end
		
		
		
	/////////////////////////////////////////////////////////////
	} // me	

} // ce
