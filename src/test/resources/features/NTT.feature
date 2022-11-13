Feature: NTTDataProje

  @NTTData
  Scenario: Tc01

    Given Kullanici ToolsQA anasayfasina gider
    When Anasayfanin acildigini kontrol eder
    When Forms kartina tiklar
    When Practice Form butonuna tiklar
    When Acilan sayfada ilgili alanlar doldurur ve submit butonuna tiklar
    When acilan pop-up ekran goruntusu alir
    When Close butonuna tiklar
    And Sayfayi kapatir
