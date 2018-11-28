      program BinaryWriter
      INTEGER A,B,C

      A=42
      B=4200
      C=42000

      OPEN(4,FILE='little.bin',STATUS='NEW',FORM='UNFORMATTED')
      WRITE(4)A,B,C
      CLOSE(4,STATUS='KEEP')
      STOP 'End of program'
      END
