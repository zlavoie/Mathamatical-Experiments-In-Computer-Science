          program write
      integer m,n, sizeofreal
      parameter (m=10, n=10, sizeofreal=4)
      real x(m,n)

c     insert some code to fill x

c     open direct access unformatted file with records sized for the whole array

      open (unit=1,
     $     file='out.r4',
     $     form='unformatted',
     $     access='direct',
     $     recl=m*n*sizeofreal)

c     write the whole thing as one record

      write (1,rec=1) x

      end

      program read

      integer m,n
      parameter (m=10, n=10)
      real x(m,n)

c     open direct access unformatted file with records sized for a single row
c     note how we can read in the data differently from how it was written.
c     You just need to make recl the smallest thing you will read and adjust
c     your read statements accordingly

      open (unit=1,
     $     file='out.r4',
     $     form='unformatted',
     $     access='direct',
     $     recl=m*4)

c     read in each row as a single record

      do j = 1, n
         read (1,rec=j) (x(i,j), i=1,m)
      end do

      end

