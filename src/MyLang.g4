grammar MyLang;

@header {
package GeneratedFiles;
}

CHAR : '[^\']';
HEX : '0'[xX][0-9A-Fa-f]+;
BITS : '0'[bB][01]+;
BOOL : 'true'|'false';
DEC : [0-9]+;
IDENTIFIER : [a-zA-Z_]([a-zA-Z_0-9])*;
STR : '"' (~('\\'|'"'))* '"' ;
argDef : IDENTIFIER (':' typeRef)?;
built: 'bool'|'byte'|'int'|'uint'|'long'|'ulong'|'char'|'string';
BINOP : '>' | '<' | '=' | '+' | '-' | ':=' | '!=';
UNOP : '!';
lit : BOOL|STR|CHAR|HEX|BITS|DEC;
WS : [ \t\r\n]+ -> skip;
COMMENT
    : '/*' .*? '*/'  -> skip
    ;

source: sourceItem* EOF;

sourceItem : funcDef;

funcDef : 'method' funcSignature (body|';') block;

block : 'begin' statement* 'end' ';';

body : ('var' ((IDENTIFIER (',' IDENTIFIER)*)? (':' typeRef)? ';')*)?;



funcSignature : IDENTIFIER '('  (argDef (',' argDef)*)? ')' (':' typeRef)?;

typeRef
    : built #builtin
    | IDENTIFIER #custom
    | 'array' '[' (',')* ']' 'of' typeRef #array
    ;

statement
    : block #statmentBlock
    | 'if' ifCondition thenStatements (elseStatements)? #statementIf
    | 'while' whileCondition 'do' whileStatements #statementWhile
    | 'repeat' doStatements ('while'|'until') doCondition ';' #statementDo
    | 'break' ';' #statementBreak
    | expr ';' #statementExpr
    ;

ifCondition
    : expr
    ;

thenStatements
    : 'then' statement*
    ;

elseStatements
    : 'else' statement*
    ;

whileCondition
    : expr
    ;

whileStatements
    : statement*
    ;

doCondition
    : expr
    ;

doStatements
    : statement*
    ;

expr
    : expr BINOP expr #binary
    | UNOP expr #unari
    |'(' expr ')' #braces
    | expr '(' (expr (',' expr)*)? ')' #call
    | expr '[' (expr (',' expr)*)? ']' #indexer
    | IDENTIFIER #place
    | lit #literal
    ;