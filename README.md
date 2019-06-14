# Java-Symmetric-Key-Encryption
Symmetric Key based cryptosystem

  This is a Symmetric Key based cypher meaning to encrypt a file is one key is generated that must be securely passed to the files recipient. This system is based on the manipulation of raw bytes in a file using the logical XOR operation. The logical XOR operation has a special property: a XOR b = c => c XOR b = a. This property trivially allows the same key to both encrypt and decrypt a file. Since the algorithm operates on bytes, it can be used to encrypt any file.
  
  This algorithm runs based on command line arguments for file locations as opposed to input through the keyboard. This means that when the jar file is run instead of simply _java -jar filename.jar_ additional arguments must be supplied, these can be in one or two formats. 
  If you have the key and want to decrypt the file or encrypt a file with the previously generated key use: _java -jar filename.jar originalFilePath destinationFilePath key_ this will take the file in _originalFilePath_ operate on it with the key and place the contents in _destinationFilePath_. 
  
  If you do not have a key and want to encrypt a file enter: _java -jar filename.jar originalFilePath destinationFilePath_ this works the same as the previous example except a new key will be generated and outputted to the console which must be saved.
  
  
  I would advise against using this cypher as a real encryption method, it has not been sufficiently tested to know whether it is easy to break or not. This program was a proof of concept not an actual product. 

Last Edit: May 11, 2018
