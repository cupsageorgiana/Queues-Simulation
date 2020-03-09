Obiectivul acestui proiect este de a modela și implementa o aplicație care se bazează pe modelul cozilor pentru a determina și minimiza timpul de așteptare a clienților.

Pentru implementarea acestei cerințe se urmărește  noțiunea de thread (fir de lucru).

Modul de utilizare a aplicatiei :
1. Din interfața grafică se vor introduce anumiți timpi necesari în vederea rulării aplicației: timpul minim în care sosește clientul, timpul maxim în care sosește clientul, timpul minim de procesare al clientului, timpul maxim de procesare al clientului, numărul de cozi care dorim să ruleze, timpul de simulare al programului.

2. Dupa ce aceste valori sunt introduse (in milisecunde) va începe rularea aplicației în momentul în care este apăsat butonul Start din interfață, timp în care la nivelul interfeței grafice se va prezenta în timp real venirea și plecarea clienților de la cozi.

3. În tot acest timp, în consolă se va afișa timpul curent (current time), precum și fiecare client când a ajuns și când a plecat, în timp ce în timpul simulării se va deschide o fereastra de log unde se va afișa în timp real informații despre fiecare client care vine care presupun timpii de ajungere și timpul de procesare al fiecărui client în parte.

În cazul în care timpii sunt introduși greșit, de exemplu, timpul minim este mai mare decat cel maxim, aplicația nu va rula și va apărea în consolă o excepție. Se recomandă introducerea cu atenție a datelor în interfața grafică. Interfața grafică suportă afișarea a numărului introdus de cozi neavând restricții de implementare, astfel încât aceasta va rula cu câte cozi îi sunt date.
