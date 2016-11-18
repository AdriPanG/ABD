xquery version "3.0";

declare variable $yoId as xs:string external;
declare variable $adversarioId as xs:string external;

for $b in doc("Abedemon.xml")/bd-abedemon//especie
let $ataque :=  $b[@id = $yoId]/ataques/tiene-ataque
let $tipoAdversario := $b[@id = $adversarioId]/tipo
return max(for $x in $ataque
    let $nombreAtaque := doc("Abedemon.xml")/bd-abedemon/ataque[@id = $x/@id]
        return for $y in $nombreAtaque/daño
            where data($y/@tipo) = doc("Abedemon.xml")/bd-abedemon//especie[@id = $adversarioId]/tipo/text()
            return data($y/@valor))