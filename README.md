# Co zostało zrobione
##### Aplikacja webowa - prezentująca dane pogodowe, poziom zanieczyszczeń smogowych w Krakowie oraz prezentująca przyszły możliwy stan
- Technologie: `Java`, `JavaScript`, `Spring`, `Hibernate`
- Biblioteki: `Charts.js`, `Highcharts`, `noUiSlider`, `Materialize`

##### Crawler - pobieranie danych poziomu zanieczyszczeń
- Technologie: `Python`

##### Regresja liniowa
- modele z różnymi cechami i reprezentacją (one-hot-encoding, sin-cos)
- Technologie: `Python`, `IPython notebook`
- Biblioteki: `Pandas`, `Numpy`, `SKLearn`


# Plany dalszego rozwoju projektu
W głównej mierze trzeba skupić się na poprawie przewidywania poziomu smogu. Zastosowaliśmy różne modele jednak zostało spore pole do usprawnień. Należy również rozpatrzeć możliwość zrefaktoryzowania kodu, jak i dodania automatycznych aktualizacji danych.

Biblioteka Charts.js stale się rozwija, więc w przyszłości można poprawić wykresy (usunięcie niepotrzebnych osi, dodanie separatora danych w zakładce “Przewidywania”, poziomu smogu i predykcji na osobne pliki). 

# Co pliki zawierają, co gdzie rozwijać
`PredictionController.java` - kontroler odpytujący bazę danych o przewidywane dane smogowe na konkretny dzień, przykładowo:
```
/prediction?date=2016-01-01&station=7&model=1
// -----
// date    -> data przewidywań danych smogowych (YYYY-MM-DD)
// station -> numer stacji (default: 7)
// model   -> numer modelu (default: 1)
```

`SmogController.java` - kontroler odpytujący bazę danych o dane smogowe, przykładowo:
```
/smog?from=2016-01-01&to=2016-01-07&station=7
// -----
// from    -> data początkowa (YYYY-MM-DD)
// to      -> data końcowa (YYYY-MM-DD)
// station -> numer stacji (default: 7)
```

`WeatherController.java` - kontroler odpytujący bazę danych o dane pogodowe, przykładowo:
```
/weather?from=2016-01-01&to=2016-01-07
// -----
// from    -> data początkowa (YYYY-MM-DD)
// to      -> data końcowa (YYYY-MM-DD)
```

`heatmapScripts.js` - skrypty do tworzenia heatmapy

`smogScripts.js`	- skrypty do tworzenia wykresów wizualizujących dane smogowe, przewidywań i porównań modeli

`weahterScripts.js` - skrypty do tworzenia wykresu wizualizującego dane pogodowe.

##### Dane smogowe i pogodowe do regresji
Wszystkie dane znajdują się w folderze `\data\regression`. Są to zapisane `python`*owe* słowniki z `padnas`*owymi* `DataFrame`*ami* w formacie `.pickle`. Są one w formie znormalizowanej jak i nieznormalizowanej. Dodatkowo w tym samym folderze dostępne są `ipython`*owe* `notebook`*i* z tworzeniem modeli.
