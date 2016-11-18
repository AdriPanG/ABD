xquery version "3.0";

distinct-values(for $b in doc("Abedemon.xml")/bd-abedemon//especie 
    return $b/tipo/text())