xquery version "3.0";

declare variable $id as xs:string external;

for $b in doc("Abedemon.xml")/bd-abedemon//especie
let $ataque :=  $b/ataques/tiene-ataque
let $evoluciones := $b//evoluciones/especie
where $b/@id = $id
return <html>
        <head></head>
        <body>
        <h1>{$b/nombre}</h1>
        <img src="{$b/url}"/>
        <p>{$b/descripcion}</p>
        <p><b>Tipos: </b>{for $x in $b
                        let $tipo := $x/tipo/text()
                        return string-join($tipo,', ')}</p>
        <p><b>Ataques: </b>{string-join(for $y in $ataque 
                        let $nombreAtaque := doc("Abedemon.xml")/bd-abedemon/ataque[@id = $y/@id]
                        order by $nombreAtaque
                        return $nombreAtaque/nombre/text(),', ')
        }</p>
        <p><b>Evoluciones: </b>
        <ul>{for $z in $evoluciones
                return <li><a href="{$z/@id}"> {$z/nombre/text()} </a></li>
            }</ul>
        </p>
        </body>
        </html>