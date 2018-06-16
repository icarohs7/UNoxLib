# UNoxLib [![GitHub version](https://badge.fury.io/gh/icarohs7%2FUNoxLib.svg)](https://badge.fury.io/gh/icarohs7%2FUNoxLib)

## Dependências

#### Gradle
```
dependencies {
	// ...
	implementation 'com.github.icarohs7.unoxlib:UNoxLib:<version>'
}

repositories {
	mavenCentral()
}
```

#### Maven
```
<dependencies>
	<!-- ... -->
	<dependency>
		<groupId>com.github.icarohs7.unoxlib</groupId>
		<artifactId>UNoxLib</artifactId>
		<version>version</version>
	</dependency>
</dependencies>
```

## Tabelas:

#### Obter instância da tabela
```java
String[] colunas = {"ID","Nome","Idade"};
String[][] dados = {
		{"1","Icaro","21"},
		{"2","Daniel","20"}
};

// Instância da tabela com os dados e colunas
JTable tabela = new ScrollTable(dados,colunas);
```

#### Tabela editavel
```java
JTable tabela = ScrollTable.ofMutableCells(dados,colunas);
```

#### Tabela a partir de um TableModel personalizado
```java
TableModel model = new DefaultTableModel(dados,colunas);

JTable tabela = ScrollTable.ofACustomModel(model);
```

#### Tabela embrulhada em um JScrollPane
```java
tabela.getScrollableTable();
```

### EditableTableModel
#### Através desse table model é possível editar livremente as células da tabela, utilizado por padrão na chamada ScrollTable.ofMutableCells
```java
JTable tabela = ScrollTable.ofMutableCells(dados,colunas);
EditableTableModel model = (EditableTableModel) tabela.getModel();
```

#### Manipulando dados da tabela
```java
// Criar tabela e obter model editável
JTable tabela = ScrollTable.ofMutableCells(dados,colunas);
EditableTableModel model = (EditableTableModel) tabela.getModel();

// Adicionar linhas à tabela
model.addRow(new String[]{"3","Maria","30"});
model.addRow(new String[]{"4","João","32"});
model.addRow(new String[]{"5","Geraldo","25"});

// Remover linhas da tabela
model.removeRow(0);
model.removeRow(0); // Quando o primeiro elemento é removido, o seguinte toma seu lugar

// Editar linhas da tabela
model.setValueAt(new String[]{"4","Marcos","28"}, 3); // Altera a quarta linha

// Editar células da tabela
model.setValueAt("Marta",2,1); // Altera a célula na linha 3 e coluna 2

// Substituir todos os dados ta tabela
String[][] novosDados = {
		{"1","Railander","21"},
		{"2","Jefersom","22"}
};

model.setAllRows(novosDados);
```