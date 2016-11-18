xquery version "3.0";
declare variable $tipo as xs:string external;

for $b in doc("Abedemon.xml")/bd-abedemon//especie
    let $num-ataques := count($b/ataques/tiene-ataque)
    let $id := $b/@id
    let $nombre := $b/nombre
    where $b/tipo = $tipo
    return <resultado id="{$id}" nombre="{$nombre}" num-ataques="{$num-ataques}"></resultado>