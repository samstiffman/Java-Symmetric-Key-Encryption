# Java-Symmetric-Key-Encryption
Symmetric Key based cryptosystem

  This is a Symmetric Key based cypher meaning when a file is encrypted one key is generated that must be securely passed on to the files recipient. This system is based on the manipulation of byte in a file as well as the logical XOR operation. The logical XOR operation has a special property: a XOR b = c => c XOR b = a. This property allows one key to be used to both encrypt and decrypt the file. 
  
  This algorithm runs based on command line arguments for file locations as opposed to input through the keyboard. This means that when the jar file is run instead of just _java -jar filename.jar_ you need to supply additional arguments these can be in one or two formats. 
  If you have the key and want to decrypt the file or encrypt a file with the previously generated key use: _java -jar filename.jar originalFilePath destinationFilePath key_ this will take the file in _originalFilePath_ operate on it with the key and place the contents in _destinationFilePath_. 
  
  If you do not have a key and want to encrypt a file enter: _java -jar filename.jar originalFilePath destinationFilePath_ this works the same as the previous example except a new key will be generated which must be saved.
  
  
  I would advise against using this cypher as a real encryption method, it has not been sufficiently tested to know whether it is easy to break or not. This program was more of a proof of concept than an actual product. 
