

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CominidadesProvincias
 */
@WebServlet("/CominidadesProvincias")
public class ComunidadesProvincias extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComunidadesProvincias() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    protected void procesaSolicitud(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	 response.setContentType("text/html;charset=UTF-8");
         PrintWriter out = response.getWriter();
    	
    	LinkedHashMap<String, String> mapaComunidades = new LinkedHashMap();
    	
    	mapaComunidades.put("Andalucia", "Almeria-Cadiz-Cordoba-Granada-Huelva-Jaen-Malaga-Sevilla");
    	mapaComunidades.put("Aragon", "Huesca-Teruel-Zaragoza");
    	mapaComunidades.put("Asturias", "Oviedo");
    	mapaComunidades.put("Baleares", "Palma de Mallorca");
    	mapaComunidades.put("Canarias", "Santa Cruz de Tenerife-Las Palmas de Gran Canaria");
    	mapaComunidades.put("Cantabria", "Santander");
    	mapaComunidades.put("Castilla la Mancha", "Albacete-Ciudad Real-Cuenca-Guadalajara-Toledo");
    	mapaComunidades.put("Castilla y Leon", "Avila-Burgos-Leon-Salamanca-Segovia-Soria-Valladolid-Zamora");
    	mapaComunidades.put("Cataluña", "Barcelona-Gerona-Lerida, Tarragona");
    	mapaComunidades.put("Comunidad Valenciana", "Alicante-Castellon de la Plana-Valencia");
    	mapaComunidades.put("Extremadura", "Badajoz-Caceres");
    	mapaComunidades.put("Galicia", "La Coruña-Lugo-Orense-Pontevedra");
    	mapaComunidades.put("Comunidad de Madrid", "Madrid");
    	mapaComunidades.put("Murcia", "Murcia");
    	mapaComunidades.put("Navarra", "Pamplona");
    	mapaComunidades.put("Pais Vasco", "Bilbao-San Sebastian-Vitoria");
    	mapaComunidades.put("La Rioja", "Logroño");
    	
    	
    	
    	
    	
    	// Comprobar si la petición es mediante Ajax
    	Boolean esAjax;
        esAjax="XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With")); // Cabecera X-Requested-With
    
        if(esAjax) {
        	String comunidad = request.getParameter("comunidad");
        	
        	String prov = "";
        	
        	for (String key : mapaComunidades.keySet()){
        		if (comunidad.equals(key)) {
        			prov = mapaComunidades.get(key);
        		}
        	}
        	
        	String provincias[] = prov.split("-");
        	
        	String respuesta ="<select id='provincia' size='5'> \n";
        	
        	for (int i = 0; i < provincias.length; i++) {
        		respuesta += "<option value=' " + provincias[i] + " ' > " + provincias[i]  + "</option> \n";
        	}
        	
        	respuesta += "</select>";
        	out.println(respuesta);
        }
    
    }
    
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesaSolicitud (request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesaSolicitud (request, response);
	}

}
