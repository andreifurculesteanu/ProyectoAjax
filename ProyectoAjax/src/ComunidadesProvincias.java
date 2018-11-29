

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
        
        
        //si la llamada es por Ajax
        if(esAjax) {
        	//Recogemos comunidad que esta seleccionada
        	String comunidad = request.getParameter("comunidad");
        	
        	//String que recoge el value(provincias) de la key(comunidades)
        	String prov = "";
        	
        	//recorremos el mapa para ver si la comunidad seleccionada coincide con algun value de mapaComunidades
        	for (String key : mapaComunidades.keySet()){
        		//si la comunidad seleccionada coincide con algun valor de mapaComunidades
        		if (comunidad.equals(key)) {
        			//asignamos el valor al string antes declarado
        			prov = mapaComunidades.get(key);
        		}
        	}
        	
        	//spliteamos prov 
        	String provincias[] = prov.split("-");
        	
        	//generamos la respuesta para pasarla al jsp con ajax
        	//abrimos select
        	String respuesta ="<select id='provincia' size='1'> \n";
        	//agregamos opciones
        	for (int i = 0; i < provincias.length; i++) {
        		respuesta += "<option value=' " + provincias[i] + " ' > " + provincias[i]  + "</option> \n";
        	}
        	//cerramos select
        	respuesta += "</select>";
        	out.println(respuesta); //pasamos respuesta al jsp con ajax
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
