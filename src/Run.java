import com.digitalpersona.onetouch.*;

public class Run {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Digital d = new Digital();
		
		try {
			Conexao c = null;
			try{
				c = new Conexao();
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
			
			DPFPTemplate dedo = d.getTemplate(null, 9);
			byte[] b; //= dedo.serialize();
			//c.incluir(2, b);
			b = c.buscar();
			
			DPFPTemplate dedo2 = DPFPGlobal.getTemplateFactory().createTemplate();
			dedo2.deserialize(b);
			if (d.verify(null, dedo))
				System.out.println("Digital verificado");
			else
				System.out.println("Digital não bate");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
