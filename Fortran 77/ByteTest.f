      program ByteTest

      subroutine endian(litend)

      integer*1 j(2)
      integer*2 i
      equivalence (i,j)
      logical litend

      i = 1
      if (j(1).eq.1) then
         litend = .true.
      else
         litend = .false.
      end if

      end

      subroutine byteswapi2(k)
      integer*1 ii(2), jj(2)
      integer*2 i, j, k
      equivalence (i,ii)
      equivalence (j,jj)

      i = k

      jj(1) = ii(2)
      jj(2) = ii(1)

      k = j

      end


      subroutine byteswapr4(r)

      integer*1 ii(4), jj(4)
      real*4 r, s, t
      equivalence (s,ii)
      equivalence (t,jj)

      s = r

      jj(1) = ii(4)
      jj(2) = ii(3)
      jj(3) = ii(2)
      jj(4) = ii(1)

      r = t

      end
