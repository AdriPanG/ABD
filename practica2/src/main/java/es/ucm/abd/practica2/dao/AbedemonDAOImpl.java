package es.ucm.abd.practica2.dao;

import es.ucm.abd.practica2.model.Abedemon;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;

import org.w3c.dom.Element;

/**
 * Implementación concreta del DAO que hace llamadas a eXist.
 * 
 * @author Manuel Montenegro (mmontene@ucm.es)
 */
public class AbedemonDAOImpl implements AbedemonDAO {

    private final XQDataSource ds;

    public AbedemonDAOImpl(XQDataSource ds) {
        this.ds = ds;
    }

    
    /**
     * Obtiene los tipos de especies disponibles en la BD.
     * 
     * @return Lista de tipos de especies (sin duplicados)
     * @throws XQException 
     * @throws IOException 
     */
	@Override
    public List<String> getTypes() throws XQException, IOException {
        // TODO: Implementar
    	List<String> abedemon = new ArrayList<String>();
    	InputStream is = getClass().getResourceAsStream("Abedemon1.xquery");
    	XQConnection con = ds.getConnection();
    	XQPreparedExpression exp = con.prepareExpression(is);
    	XQResultSequence rs = exp.executeQuery();
    	while (rs.next())
    		abedemon.add(rs.getItemAsString(null));
    	
    	is.close();
    	con.close();
    	exp.close();
    	rs.close();
    	
        return abedemon;
    }

    /**
     * Obtiene las especies de abedemon de un determinado.
     * 
     * @param type Tipo a buscar
     * @return Especies encontradas del tipo pasado como parámetro.
     * @throws XQException 
     * @throws IOException 
     */
    @Override
    public List<Abedemon> getAbedemonsOf(String type) throws XQException, IOException {
        // TODO: Implementar
    	List<Abedemon> abedemon = new ArrayList<Abedemon>();
    	InputStream is = getClass().getResourceAsStream("Abedemon2.xquery");
    	XQConnection con = ds.getConnection();
    	XQPreparedExpression exp = con.prepareExpression(is);
    	exp.bindString(new QName("tipo"), type,null);
    	XQResultSequence rs = exp.executeQuery();
    	Element e;
    	Abedemon a;
    	while (rs.next()) {
    		e = (Element) rs.getObject();
    		a = new Abedemon(e.getAttribute("id"), e.getAttribute("nombre"), Integer.parseInt(e.getAttribute("num-ataques")));
    		abedemon.add(a);
    	}
    	is.close();
    	con.close();
    	exp.close();
    	rs.close();
    	
        return abedemon;
    }

    /**
     * Obtiene la descripción de una especie de abedemon.
     * 
     * @param id ID de la especie a describir
     * @return Código XHTML con la descripción de la especie
     * @throws XQException 
     * @throws IOException 
     */
    @Override
    public String getAbedemonDescription(String id) throws XQException, IOException {
        // TODO: Implementar
    	String daño = null;
    	InputStream is = getClass().getResourceAsStream("Abedemon3.xquery");
    	XQConnection con = ds.getConnection();
    	XQPreparedExpression exp = con.prepareExpression(is);
    	exp.bindString(new QName("id"), id,null);
    	XQResultSequence rs = exp.executeQuery();
    	if (rs.next())
    		daño = rs.getItemAsString(null);
    	
    	is.close();
    	con.close();
    	exp.close();
    	rs.close();
    	
    	return daño;
    }

    /**
     * Obtiene el daño máximo recibido por un abedemon de una especie dada al
     * ser atacado por otro.
     * 
     * @param idAttacker ID de la especie del atacante.
     * @param idReceiver ID de la especie que recibe el daño.
     * @return Máximo daño que puede infligir el atacante.
     * @throws XQException 
     * @throws IOException 
     */
    @Override
    public Integer getDamage(String idAttacker, String idReceiver) throws XQException, IOException {
        // TODO: Implementar (parte opcional)
    	Integer daño = null;
    	InputStream is = getClass().getResourceAsStream("Abedemon4.xquery");
    	XQConnection con = ds.getConnection();
    	XQPreparedExpression exp = con.prepareExpression(is);
    	exp.bindString(new QName("yoId"), idAttacker,null);
    	exp.bindString(new QName("adversarioId"), idReceiver,null);
    	XQResultSequence rs = exp.executeQuery();
    	if (rs.next()) 
    		daño = Integer.parseInt(rs.getItemAsString(null));
    	
    	is.close();
    	con.close();
    	exp.close();
    	rs.close();
    	
    	return daño;
    }
}
