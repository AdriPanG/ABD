package es.ucm.abd.practica2.dao;

import es.ucm.abd.practica2.model.Abedemon;

import java.io.IOException;
import java.util.List;

import javax.xml.xquery.XQException;

/**
 * Acceso a datos del Abedemon
 * 
 * @author Manuel Montenegro (mmontene@ucm.es)
 */
public interface AbedemonDAO {
    List<String> getTypes() throws XQException, IOException;
    List<Abedemon> getAbedemonsOf(String type) throws XQException, IOException;
    String getAbedemonDescription(String id) throws XQException, IOException;
    Integer getDamage(String idAttacker, String idReceiver) throws XQException, IOException;
}
